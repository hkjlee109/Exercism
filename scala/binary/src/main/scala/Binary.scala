case class Binary(s: String) {

  lazy val toDecimal = processToDecimal(s) getOrElse 0

  private def processToDecimal(input: String): Option[Int] ={
    if(isBinary(input)) Some(input.foldLeft(0)(_ * 2 + _.asDigit))
    else                None
  }

  private def isBinary(s: String) = s.forall(c => c == '0' || c == '1')

}
