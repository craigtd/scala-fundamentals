package calculator

import calculator.Calculator._
import org.scalatest.prop.PropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class CalculatorSpec extends FlatSpec with Matchers with PropertyChecks{

  "1 1 +" should "return 2" in {
    val expression = (parse("1 1 +"))
    calculate(expression) shouldBe 2
    println(s"${toInfix(expression)}")
  }

  "1 2 3 + -" should "return -4" in {
    val expression = (parse("1 2 3 + -"))
    calculate(expression) shouldBe -4
    println(s"${toInfix(expression)}")
  }

  "1 2 + 3 4 5 - - * 6 7 8 - * /" should "return -2" in {
    val expression = parse("1 2 + 3 4 5 - - * 6 7 8 - * /")
    calculate(expression) shouldBe -2

    println(s"${toInfix(expression)}")
  }


  "postfix expressions" should "convert to the infix version" in {
    val input = Table(
      "postfix expression"            -> "infix expression",
      //==================================================
      "1 1 +"                         -> "(1 + 1)",
      "1 2 3 + -"                     -> "(1 - (2 + 3))",
      "1 2 + 3 4 5 - - * 6 7 8 - * /" -> "(((1 + 2) * (3 - (4 - 5))) / (6 * (7 - 8)))"
    )
    forAll(input) {
      case (postfix, infix) => toInfix(parse(postfix)) shouldBe infix
    }
  }



  it should "produce IllegalArgumentException when garbage is provided" in {
    assertThrows[IllegalArgumentException] {
      parse("garbage")
    }
  }

  it should "produce IllegalArgumentException when no arguments are provided" in {
    assertThrows[IllegalArgumentException] {
      parse("")
    }
  }

}
