package generics

class Dog { override val toString = "Dog" }
class Puppy extends Dog { override val toString = "Puppy" }

case class Box[A](private var contents: A)

object Box {
  def putPuppy[A >: Puppy](box: Box[A]) : Unit = box.contents = new Puppy
  def getDog[A <: Dog](box: Box[A]): A = box.contents

  val puppyBox = Box(new Puppy)
  val dogBox = Box(new Dog)
}
