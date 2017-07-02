object TriangleType extends Enumeration {
  val Equilateral, Isosceles, Scalene, Illogical = Value
}

case class Triangle(a: Int, b: Int, c: Int) {
  private val triangleLines = List(a, b, c)

  def triangleType: TriangleType.Value = {
    if(isIllogical(triangleLines))
      TriangleType.Illogical
    else {
      triangleLines.toSet.size match {
        case 1 => TriangleType.Equilateral
        case 2 => TriangleType.Isosceles
        case 3 => TriangleType.Scalene
      }
    }
  }

  private def isIllogical(lines: List[Int]): Boolean = {
    lines forall (_ > 0) match {
      case true => {
        lines.sorted match {
          case List(min, mid, max) if(max > min + mid) => true
          case _ => false
        }
      }
      case false => true
    }
  }
}
