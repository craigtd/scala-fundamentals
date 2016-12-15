package cookbook

import org.scalatest.{FlatSpec, Matchers}

class CookbookSpec extends FlatSpec with Matchers{

  "Recipes r1 and r2" should " be the same" in {
    val r1 = Recipe(Map.empty, List.empty)
    val r2 = Recipe(Map.empty, List.empty)
    assert (r1 == r2)
  }

  "Using a case class" should "allow us to see use the unapply method to extract information" in {
    Cookbook.pbj match {
      case Recipe(ingredients, directions) =>
        assert(ingredients == Map("peanut butter" -> Grams(10), "jelly" -> Kilograms(0.5), "bread" -> Grams(250)))
        assert(directions == List("put the peanut butter and jelly on the bread"))
    }
  }



}
