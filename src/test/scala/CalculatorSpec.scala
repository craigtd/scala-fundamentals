import org.scalatest.{FlatSpec, Matchers}
import Calculator._

class CalculatorSpec extends FlatSpec with Matchers{

  "1 1 +" should "return 2" in {
    assert(calculate("1 1 +") == 2)
  }

  "1 2 + 3 4 5 - - * 6 7 8 - * /" should "return -2" in {
    assert(calculate("1 2 + 3 4 5 - - * 6 7 8 - * /") == -2)
  }

}
