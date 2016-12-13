package cookbook

// make the constructor for Recipe private - means you need a factory method to construct an object
class Recipe private (
              val ingredients: List[String] = List.empty,
              val directions: List[String] = List.empty) {
  println("Ingredients: " + ingredients)
  println("Directions: " + directions)
}

// Companion object to Recipe class which can contain the static methods
// Note that the object Recipe ISN'T an instance of the class Recipe
object Recipe {
  //Factory method defined as a static method
  def make(ingredients: List[String], directions: List[String]): Recipe =
    new Recipe(ingredients, directions)
}

//class Cookbook(val recipes: Map[String, Recipe]) {
//  println("Recipes: " + recipes)
//
//  // Auxillary constructor - overload the meaning of 'this' to chain to the primary constructor
//  def this() = this(Map.empty)
//}

object Cookbook {
  val pbj = Recipe.make(
    List("peanut butter", "jelly", "bread"),
    List("put the peanut butter and jelly on the bread"))

  val baconPancakes = Recipe.make(
    List("bacon", "pancakes"),
    List("take some bacon and put it in a pancake"))

}