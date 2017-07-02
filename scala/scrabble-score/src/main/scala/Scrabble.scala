case class Scrabble() {
  private val scoreMap: Map[Seq[Char], Int] = Map( (Seq('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T') -> 1),
                                                   (Seq('D', 'G') -> 2),
                                                   (Seq('B', 'C', 'M', 'P') -> 3),
                                                   (Seq('F', 'H', 'V', 'W', 'Y') -> 4),
                                                   (Seq('K') -> 5),
                                                   (Seq('J', 'X') -> 8),
                                                   (Seq('Q', 'Z') -> 10) )
  private val letterToScoreMap =
    for ((letters, score) <- scoreMap; letter <- letters) yield letter -> score

  def scoreLetter(c: Char) = letterToScoreMap(c.toUpper)
  def scoreWord(s: String) = s map scoreLetter sum
}
