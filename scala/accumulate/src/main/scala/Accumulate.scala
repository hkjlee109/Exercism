case class Accumulate() {
  def accumulate[T1, T2](function: (T1) => T2, data: List[T1]): List[T2] = {
    data match {
      case Nil => List.empty
      case x :: tail => function(x) :: accumulate[T1, T2](function, tail)
    }
  }
}
