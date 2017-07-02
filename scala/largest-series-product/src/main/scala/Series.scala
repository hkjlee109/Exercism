import scala.annotation.tailrec

object Series {
  def largestProduct(n: Int, s: String) = process(n, s, None)

  @tailrec
  private def process(n: Int, s: String, max: Option[Int]): Option[Int] = {
    n match {
      case 0 => Some(1)
      case x if (x > s.length) => max
      case _ => process(n, s.drop(1), Some(getMaxProduct(s.take(n), max)))
    }
  }

  private def getMaxProduct(s: String, max: Option[Int]) = {
    math.max((s.sorted.reverse).foldLeft(1)(_ * _.asDigit), max.getOrElse(0))
  }
}
