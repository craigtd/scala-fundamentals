package cookbook

// Using a case class gives apply/unapply, equals, hashcode, copy and toString for free
// called case classes because we use them in pattern matching
case class Recipe (ingredients: List[String], directions: List[String])

object Cookbook {
  val pbj = Recipe(
    List("peanut butter", "jelly", "bread"),
    List("put the peanut butter and jelly on the bread"))

  val baconPancakes = Recipe(
    List("bacon", "pancakes"),
    List("take some bacon and put it in a pancake"))

}