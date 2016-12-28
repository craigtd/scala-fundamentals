package functions

import org.scalatest.{FlatSpec, Matchers}


class FunctionsSpec extends FlatSpec with Matchers{

  "foldLeft of List(1,2,3) and accumulating from 0" should "return" in {
    val fn = (acc: Int, e: Int) => acc + e
    functions.foldLeft(List(1,2,3), 0)(fn) shouldBe 6
  }

  "map of List(1,2,3) and multiplying by 2" should "return List(2,4,6)" in {
    val result = List(1,2,3).map({a: Int => a * 2})
    result shouldBe List[Int](2,4,6)
  }

  "shorthand map of List(1,2,3) and multiplying by 2" should "return List(2,4,6)" in {
    val result = List(1,2,3).map{a: Int => a * 2}
    result shouldBe List[Int](2,4,6)
  }

  "even shorterhand map of List(1,2,3) and multiplying by 2" should "return List(2,4,6)" in {
    val result = List(1,2,3) map { _ * 2}
    result shouldBe List[Int](2,4,6)
  }

  "curried map of List(1,2,3) and adding one" should "return List(2,3,4)" in {
    val result = map(List(1,2,3)) { _ + 1 }
    result shouldBe List(2,3,4)
  }

  "filter of List(1,2,3,4,5) with mod 2" should "return List(2,4)" in {
    val result = List(1,2,3,4,5) filter {_ % 2 == 0}
    result shouldBe List[Int](2,4)
  }

  "shorthand foldLeft of List(1,2,3) and accumulating from 1" should "return 6" in {
    List(1, 2, 3).foldLeft(1) { _ + _ } shouldBe 7
  }

  "partition of List(1,2,3,4,5) with mod 2" should "return (List(2,4), List(1,3,5))" in {
    val result = List(1,2,3,4,5) partition { _ % 2 ==0 }
    result shouldBe (List(2,4), List(1,3,5))
  }

  "takeWhile List(1,2,3,4,5) and < 4 " should "return List(1,2,3)" in {
    val result = List(1,2,3,4,5,4,3,2,1) takeWhile {_ < 4 }
    result shouldBe List(1,2,3)
  }

  "dropWhile List(1,2,3,4,5,4,3,2,1) and < 4 " should "return List(4,5,4,3,2,1)" in {
    val result = List(1,2,3,4,5,4,3,2,1) dropWhile {_ < 4 }
    result shouldBe List(4,5,4,3,2,1)
  }

  "span of List(1,2,3,4,5,4,3,2,1) and < 4" should " return (List(1,2,3), List(4,5,4,3,2,1))" in {
    val result = List(1,2,3,4,5,4,3,2,1) span { _ < 4 }
    result shouldBe (List(1,2,3), List(4,5,4,3,2,1))
  }

  "groupBy" should "return a map of results" in {
    val result = List("hello", "my", "name", "is", "craig") groupBy {_.length}
    result shouldBe Map(2 -> List("my", "is"), 5 -> List("hello", "craig"), 4 -> List("name"))
  }

  "using a curried plus one function" should "return 2" in {
    val result = plus(1)(1)
    result shouldBe 2
  }

  "using v2 of a curried plus one function" should "return 2" in {
    val result = plusv2(1)(1)
    result shouldBe 2
  }

}

