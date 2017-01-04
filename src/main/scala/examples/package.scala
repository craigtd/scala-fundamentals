package object examples {

  def printAll(list: List[_]): Unit = list match {
    case head :: tail =>
      println(head)
      printAll(tail)
    case Nil => ()
  }

  def length(list: List[_]): Int = list match {
    case _ :: tail => 1 + length(tail)
    case _ => 0
  }

  def toStringAll(list: List[_]): List[String] = list match {
    case head :: tail => head.toString :: toStringAll(tail)
    case _ => Nil
  }

  val toStringAll2: (List[_]) => List[String] = _ match {
    case head :: tail => head.toString :: toStringAll2(tail)
    case _ => Nil
  }


  // 6.2 avoid common mistakes

  val a = 1
  val b = 2

  // use `a` to explicitly refer to the previously defined constant value a rather than binding a new variable a (which would mess up the pattern matching)
  def oneOrTwo(n: Int): String = n match {
    case `a` => "one!"
    case `b` => "two!"
  }

  // type inference only works forwards so we need to specify the type of the empty list
  def reverse[A] (list: List[A]) : List[A] = list.foldLeft(List.empty[A]) {
    (acc, elem) => elem :: acc
  }

  // an example of unreadable code which implements the same behaviour as reverse
  def wat[A] = (_: List[A])./:(List.empty[A])(_.::(_))

}
