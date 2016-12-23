package object functions {

  def map[A, B](list: List[A], fn: A => B): List[B] = list match {
    case head :: tail => fn(head) :: map(tail, fn)
    case _ => Nil
  }


  def filter[A](list: List[A], fn: A => Boolean): List[A] = list match {
    case head :: tail =>
      val rest = filter(tail, fn)
      if (fn(head))
        head :: rest
      else
        rest
    case _ => Nil
  }

  /**
    * Function which walks from the left to the right of a list and accumulates as it goes
    */
  def foldLeft[A, B](list: List[A], acc: B, fn: (B,A) => B): B = list match {
    case head :: tail => foldLeft(tail, fn(acc, head), fn)
    case _ => acc
  }


}
