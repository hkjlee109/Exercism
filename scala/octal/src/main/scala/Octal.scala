import scala.annotation.tailrec

object Octal {

  def intToOctal(decimal: Int) = {
    processIntToOctal(decimal, List()) match {
      case List() => "0"
      case notEmptyList => notEmptyList.mkString
    }
  }

  @tailrec
  private def processIntToOctal(quotient: Int, answer: List[Int]): List[Int] = {
    quotient match {
      case 0 => answer
      case _ => processIntToOctal(quotient / 8, (quotient % 8) :: answer)
    }
  }

  def octalToInt(octal: String): Int = {
    require(!octal.isEmpty)
    require(octal forall (_.asDigit < 9))

    for {
      i <- (0 until octal.length)
      c = (octal.reverse) (i)
    } yield {
      (c.asDigit * Math.pow(8, i).toInt)
    }
  }.foldLeft(0)(_ + _)

}
