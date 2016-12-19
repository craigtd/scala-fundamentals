package calculator

import calculator.Calculator._
import org.scalatest.{FlatSpec, Matchers}

class CalculatorSpec extends FlatSpec with Matchers{

  "1 1 +" should "return 2" in {
    val expression = (parse("1 1 +"))
    assert(calculate(expression) == 2)
    println(s"${toInfix(expression)}")
  }

  "1 2 3 + -" should "return -4" in {
    val expression = (parse("1 2 3 + -"))
    assert(calculate(expression) == -4)
    println(s"${toInfix(expression)}")
  }

  "1 2 + 3 4 5 - - * 6 7 8 - * /" should "return -2" in {
    val expression = parse("1 2 + 3 4 5 - - * 6 7 8 - * /")
    assert(calculate(expression) == -2)
    println(s"${toInfix(expression)}")
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
