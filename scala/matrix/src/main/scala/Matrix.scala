case class Matrix(s: String) {
  lazy val matrix = s.split("\n").map(_.split(" ").map(_.toInt).toList).toList
  lazy val matrixTranspose = matrix.transpose

  def rows(n: Int): Vector[Int] = matrix(n).toVector
  def cols(n: Int): Vector[Int] = matrixTranspose(n).toVector
}
