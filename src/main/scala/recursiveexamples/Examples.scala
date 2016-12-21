package recursiveexamples

object Examples {

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


}
