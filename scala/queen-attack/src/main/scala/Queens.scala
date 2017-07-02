case class Queens() {

  private val BOARDSIZE = 8

  var chessBoard: Map[Int, List[Char]] = Map(
    {0 -> List('_', '_', '_', '_', '_', '_', '_', '_')},
    {1 -> List('_', '_', '_', '_', '_', '_', '_', '_')},
    {2 -> List('_', '_', '_', '_', '_', '_', '_', '_')},
    {3 -> List('_', '_', '_', '_', '_', '_', '_', '_')},
    {4 -> List('_', '_', '_', '_', '_', '_', '_', '_')},
    {5 -> List('_', '_', '_', '_', '_', '_', '_', '_')},
    {6 -> List('_', '_', '_', '_', '_', '_', '_', '_')},
    {7 -> List('_', '_', '_', '_', '_', '_', '_', '_')}
  )

  def boardString(posWhite: Option[Position], posBlack: Option[Position]) = {
    placeQueen(posWhite, 'W')
    placeQueen(posBlack, 'B')
    printChessBoard
  }

  def canAttack(from: Position, to: Position) = {
    placeQueen(Some(from), 'W')
    placeQueen(Some(to), 'B')

    (from.y == to.y) || (from.x == to.x) ||
      isQueen(Position((from.y + (to.y - from.y)), from.x - Math.abs(to.y - from.y))) ||
        isQueen(Position((from.y + (to.y - from.y)), from.x + Math.abs(to.y - from.y)))

  }

  private def placeQueen(pos: Option[Position], icon:Char) = {
    pos match {
      case Some(p) => chessBoard += { p.y -> (chessBoard.get(p.y).get).patch(p.x, Seq(icon), 1) }
      case None    => None
    }
  }

  private def isQueen(pos: Position): Boolean = {
    if (((0 until BOARDSIZE) contains pos.x) && ((0 until BOARDSIZE) contains pos.y))
      (chessBoard.get(pos.y).get)(pos.x) != '_'
    else
      false
  }

  private lazy val printChessBoard = {
    for ( i <- (0 until BOARDSIZE) )
      yield { (chessBoard get i).get.mkString("", " ", "\n") }
  }.mkString

}

case class Position(coordY: Int, coordX: Int) {
  val y = coordY;
  val x = coordX;
}
