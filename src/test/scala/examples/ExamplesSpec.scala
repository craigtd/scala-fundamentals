package examples

import org.scalatest.{FlatSpec, Matchers}


class ExamplesSpec extends FlatSpec with Matchers{

  "length of List(1,2,3)" should "return 3" in {
    examples.length(List(1, 2, 3)) shouldBe 3
  }

  "toStringAll of List(1,2,3)" should "return a list of strings" in {
    toStringAll(List(1, 2, 3)) shouldBe an[List[Int]]
  }

  "toStringAll2 of List(1,2,3" should "return a list of strings" in {
    toStringAll2(List(1, 2, 3)) shouldBe an[List[Int]]
  }


  // 6.2 avoid common mistakes

  "oneOrTwo of 1" should "return one" in {
    oneOrTwo(1) shouldBe "one!"
  }

  "oneOrTwo of 2" should "return two" in {
    oneOrTwo(2) shouldBe "two!"
  }

  "reverse of List(1,2,3)" should "return List(3,2,1)" in {
    reverse(List(1, 2, 3)) shouldBe List(3, 2, 1)
  }

  "wat of List(1,2,3)" should "return List(3,2,1)" in {
    wat(List(1, 2, 3)) shouldBe List(3, 2, 1)
  }

}
