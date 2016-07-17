case class Dna() {
  private val dictionary: Map[Char, Char] = Map (
    ('G' -> 'C'), ('C' -> 'G'), ('T' -> 'A'), ('A' -> 'U')
  )

  def toRna(s: String): String = s map dictionary
}
