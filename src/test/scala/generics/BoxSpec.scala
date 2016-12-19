package generics

import org.scalatest.{FlatSpec, Matchers}
import generics.Box._

class BoxSpec extends FlatSpec with Matchers{

  "Puppy" should "be put a puppy in the dog box" in {
    putPuppy(dogBox)
  }

  "Get dog" should "get a puppy from the puppy box" in {
    getDog(puppyBox) shouldBe an[Puppy]
  }


}
