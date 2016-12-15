package cookbook

// Using a case class provides apply/unapply, equals, hashcode, copy and toString for free
// called case classes because we use them in pattern matching
case class Recipe (ingredients: Map[String, Mass], directions: List[String]) {
  def shoppingList(kitchen: Map[String, Mass]): List[String] =
    for {
      (name, need) <- ingredients.toList
      have = kitchen.getOrElse(name, Grams(0))
      if have.compareTo(need) < 0
    } yield name
}

// This is an algebraic data type
// sealed keyword means that no other classes outside this file can extend this
// this can be useful to ensure that pattern matching can be exhaustive
// general rule, make abstract defs so you can override
sealed abstract class Mass extends Comparable[Mass]{
  def amount: Double
  def toGrams : Grams
  def compareTo(that: Mass): Int = (this.toGrams.amount - that.toGrams.amount).toInt
}
case class Grams(amount: Double) extends Mass {
  override def toGrams: Grams = this
  override def toString: String = amount + "g"
}
case class Milligrams(amount: Double) extends Mass {
  override def toGrams: Grams = Grams (amount / 1000)
  override def toString: String = amount + "mg"
}
case class Kilograms(amount: Double) extends Mass {
  override def toGrams: Grams = Grams (amount * 1000)
  override def toString: String = amount + "kg"
}


object Cookbook {
  val pbj = Recipe(
    Map("peanut butter" -> new Grams(10),
      "jelly" -> new Kilograms(0.5),
      "bread" -> new Grams(250)),
    List("put the peanut butter and jelly on the bread"))

  val baconPancakes = Recipe(
    Map("bacon" -> new Kilograms(1), "pancakes" -> new Milligrams(10)),
    List("take some bacon and put it in a pancake"))

}