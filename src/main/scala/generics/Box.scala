package generics

class Dog
class Puppy extends Dog

// -A indicates PutBox is contravariant in the type parameter A
// this is a write only data structure where it is safe to make the substitution
trait PutBox[-A] {
  def put(value: A): Unit = ???
}

// +A indicates GetBox is covariant in the type parameter A
// this is a read only data structure where it is safe to make the substitution
trait GetBox[+A] {
  def get: A = ???
}

trait PutGetBox[A] extends PutBox[A] with GetBox[A]

object Boxes {
  def putPuppy(box: PutBox[Puppy]): Unit = box.put(new Puppy)
  def getDog(box: GetBox[Dog]): Dog = box.get

  val dogPutBox = new PutBox[Dog] {}
  val dogGetBox = new GetBox[Dog] {}
  val puppyPutBox = new PutBox[Puppy] {}
  val puppyGetBox = new GetBox[Puppy] {}

  putPuppy(puppyPutBox)
  putPuppy(dogPutBox)
  getDog(dogGetBox)
  getDog(puppyGetBox)

}

