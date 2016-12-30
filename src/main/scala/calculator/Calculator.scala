package calculator

import scala.collection.mutable.Stack

// Singleton class Calculator
object Calculator {

  // 5.5 replace trait Operator with type alias
  type Operator = (Int, Int) => Int

  // 5.5 replace case objects with function literals
  object Operator {
    val operators: Map[String, Operator] =
      Map("+" -> { _ + _ },
          "-" -> { _ - _ },
          "*" -> { _ * _ },
          "/" -> { _ / _ })
    // an inverse map to get the strings from the functions
    val tokens = operators map { _.swap }
    def unapply(token:String): Option[Operator] =
      operators.get(token)
  }


  object Number {
    def unapply(token:String): Option[Int] = try {
      Some(token.toInt)
    } catch {
      case _ : NumberFormatException => None
    }
  }


  sealed trait Expression
  case class NumberExpression(value: Int) extends Expression
  case class OperationExpression(lhs: Expression, rhs: Expression, op: Operator) extends Expression


  // 5.5 helper method to assist with looping through the stack
  def step(stack: List[Expression], token: String): List[Expression] = token match {
    case Number(num) => NumberExpression(num) :: stack
    case Operator(op) => stack match {
      case rhs :: lhs :: rest => OperationExpression(lhs, rhs, op) :: rest
      case _ => throw new IllegalArgumentException("not enough operands")
    }
    case _ => throw new IllegalArgumentException("invalid token: " + token)
  }


  /**
    * parse a postfix notation expression
    */
  def parse(expression: String): Expression = {
    val tokens = expression.split(" ")
    val stack = tokens.foldLeft(List.empty[Expression]) { step }
    stack.head
  }

  def calculate(expression: Expression): Int = expression match {
    case NumberExpression(value) => value
    case OperationExpression(lhs, rhs, op) => op(calculate(lhs), calculate(rhs))
  }

  def toInfix(expression: Expression): String = expression match {
    case NumberExpression(value) => value.toString
    case OperationExpression(lhs, rhs, op) => s"(${toInfix(lhs)} ${Operator.tokens(op)} ${toInfix(rhs)})"

  }

  def main(args: Array[String]): Unit =
    if (args.length != 1) {
      throw new IllegalArgumentException("Usage calculator <expression>")
    } else {
      val expression = parse(args(0))
      println(s"${toInfix(expression)} = ${calculate(expression)}")
    }
}
