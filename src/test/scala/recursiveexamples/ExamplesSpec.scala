package recursiveexamples
import org.scalatest.{FlatSpec, Matchers}


class ExamplesSpec extends FlatSpec with Matchers{

  "length of List(1,2,3)" should "return 3" in {
    Examples.length(List(1,2,3)) shouldBe 3
  }

  "toStringAll of List(1,2,3)" should "return a list of strings" in {
    Examples.toStringAll(List(1,2,3)) shouldBe an[List[Int]]
  }

}