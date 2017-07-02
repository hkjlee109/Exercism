import scala.annotation.tailrec

case class PrimeFactors() {
  def primeFactors(n: Long) = {
    process(n, 2, List())
  }

  @tailrec
  private def process(n: Long, d: Long, result: List[Long]): List[Long] = {
    n match {
      case 1 => result.reverse
      case x if(n % d == 0) => process(n / d, d, d :: result)
      case _ => process(n, d+1, result)
    }
  }
}
