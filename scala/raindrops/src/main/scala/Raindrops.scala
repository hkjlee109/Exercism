case class Raindrops() {
  private val raindropMap = Map({3 -> "Pling"}, {5 -> "Plang"}, {7 -> "Plong"})

  def convert(n: Int) = {
    val answerList = {
      for ((factor, raindrops) <- raindropMap; if (n % factor == 0)) yield raindrops
    }

    answerList match {
      case List() => n.toString
      case x => x.mkString
    }
  }
}