import scala.annotation.tailrec

case class RomanNumeral(n: Int) {
  val integerList = List(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
  val romanNumeralMap = Map({1 -> "I"}, {4 -> "IV"}, {5 -> "V"}, {9 -> "IX"}, {10->"X"},
                            {40 -> "XL"}, {50 -> "L"}, {90 -> "XC"}, {100 -> "C"}, {400 -> "CD"},
                            {500-> "D"}, {900->"CM"}, {1000 -> "M"})

  val value = process(n, integerList, List()).mkString

//  @tailrec
//  private def process(n: Int, list: List[Int], answer: List[String]): List[String] = {
//    n match {
//      case 0 => answer.reverse
//      case x if(x >= list.head) => process(n-list.head, list, romanNumeralMap(list.head).toString :: answer)
//      case _ => process(n, list.tail, answer)
//    }
//  }

  @tailrec
  private def process(n: Int, list: List[Int], answer: List[String]): List[String] = {
    n match {
      case 0 => answer.reverse
      case x if(x >= list.head) => process(n-list.head, list, romanNumeralMap(list.head).toString :: answer)
      case _ => process(n, list.tail, answer)
    }
  }

}
