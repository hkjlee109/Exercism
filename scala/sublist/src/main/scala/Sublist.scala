import scala.annotation.tailrec

object Sublist extends Enumeration {
  val Superlist, Sublist, Equal, Unequal = Value
}

case class Sublist() {
  def sublist[T](left: List[T], right: List[T]): Sublist.Value = {
    left.lengthCompare(right.length) match {
      case 0  if (left.isEmpty || LeftIsSublistOfRight(left, right))  => Sublist.Equal
      case -1 if (left.isEmpty || LeftIsSublistOfRight(left, right))  => Sublist.Sublist
      case 1  if (right.isEmpty || LeftIsSublistOfRight(right, left)) => Sublist.Superlist
      case _                                                          => Sublist.Unequal
    }
  }

  @tailrec
  private def LeftIsSublistOfRight[T](left: List[T], right: List[T]): Boolean = {
    right match {
      case Nil => false
      case x if (left.head != right.head)         => LeftIsSublistOfRight(left, right.tail)
      case x if (left == right.take(left.length)) => true
      case _                                      => LeftIsSublistOfRight(left, right.tail)
    }
  }
}