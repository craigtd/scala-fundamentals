package cookbook

import org.scalatest.{FlatSpec, Matchers}

class CookbookSpec extends FlatSpec with Matchers{

  "Recipes r1 and r2" should " be the same" in {
    val r1 = Recipe(List.empty, List.empty)
    val r2 = Recipe(List.empty, List.empty)
    assert (r1 == r2)
  }

  "Using a case class" should "allow us to see use the unapply method to extract information" in {
    Cookbook.pbj match {
      case Recipe(ingredients, directions) =>
        assert(ingredients == List("peanut butter", "jelly", "bread"))
        assert(directions == List("put the peanut butter and jelly on the bread"))
    }
  }



}
