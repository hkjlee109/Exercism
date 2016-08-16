object Hexadecimal {
  private val hex2dec = (('0' to '9').toList ::: ('a' to 'f').toList).zipWithIndex.toMap

  def hexToInt(s: String) = {
    if(isHex(s)) s.toLowerCase.foldLeft(0)(_ * 16 + hex2dec.get(_).get)
    else 0
  }

  private def isHex(s: String) = s.toLowerCase.forall(c => hex2dec.contains(c))
}