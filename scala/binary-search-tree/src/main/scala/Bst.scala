import scala.math.Ordered._

case class Bst[T: Ordering](v: T, var left: Option[Bst[T]], var right: Option[Bst[T]]) {
  val value = v

  def insert(v: T): Bst[T] = {
    if (v >= this.value) {
      right match {
        case None    => { this.copy(right = Some(Bst(v))) }
        case Some(b) => Bst(b.insert(v)
      }
    }
    else if (v < this.value) {
      left match {
        case None    => { this.copy(left = Some(Bst(v))) }
        case Some(b) => b.insert(v)
      }
    }
    else { this }
  }

  def getSubTreeList(b: Bst[T]): List[T] = {
    b match {
      case Bst(v, None, None) => List(v)
      case Bst(v, left, None) => getSubTreeList(left.get) ::: List(v)
      case Bst(v, None, right) => List(v) ::: getSubTreeList(right.get)
      case Bst(v, left, right) => getSubTreeList(left.get) ::: List(v) ::: getSubTreeList(right.get)
    }
  }
}

object Bst {
  def apply[T: Ordering](n: T) = new Bst(n, None, None)

  def fromList[T: Ordering](l: List[T]) = {
    val top = new Bst(l.head, None, None)
    l.tail.map(top.insert(_))
    top
  }

  def toList[T: Ordering](b: Bst[T]) = b.getSubTreeList(b)
}