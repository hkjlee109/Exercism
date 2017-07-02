import Luhn._

case class Luhn(n: Long) {
  private val ns = n.toString

  lazy val checkDigit = n % 10
  lazy val checksum   = addends.sum % 10
  lazy val isValid    = (checksum == 0)

  def create = {
    ns + (0 to 9).filter(c => Luhn((ns + c).toLong).isValid).toList.mkString
  }.toLong

  def addends = {
    val list = ns.reverse.map(_.asDigit).toList

    List.tabulate(list.size) { i =>
      if ((i + 1) % 2 == 0) getCipher(list(i))
      else list(i)
    }.reverse
  }
}

object Luhn {
  private def getCipher(n: Int): Int = {
    n * 2 match {
      case x if (x > 9) => x - 9
      case x            => x
    }
  }
}