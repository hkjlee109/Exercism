case class Year(year: Int) {
  val isLeap = year match {
    case y if year % 400 == 0 => true
    case y if year % 100 == 0 => false
    case y if year % 4   == 0 => true
    case _ => false
  }
}
