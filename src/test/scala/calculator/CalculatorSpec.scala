package calculator

import calculator.Calculator._
import org.scalatest.{FlatSpec, Matchers}

class CalculatorSpec extends FlatSpec with Matchers{

  "1 1 +" should "return 2" in {
    assert(calculate("1 1 +") == 2)
  }

  "1 2 + 3 4 5 - - * 6 7 8 - * /" should "return -2" in {
    assert(calculate("1 2 + 3 4 5 - - * 6 7 8 - * /") == -2)
  }

  it should "produce IllegalArgumentException when no arguments are provided" in {
    assertThrows[IllegalArgumentException] {
      calculate("")
    }
  }

}
