object Bearing extends Enumeration {
  val North, East, South, West = Value
}

case class Robot(bearing: Bearing.Value, coordinates: (Int, Int)) {

  lazy val turnRight: Robot = copy(
    bearing = Bearing.apply((bearing.id + 1) % Bearing.maxId)
  )

  lazy val turnLeft: Robot = copy(
    bearing = bearing.id match {
      case 0  => Bearing.apply((Bearing.maxId - 1))
      case id => Bearing.apply((bearing.id - 1) % Bearing.maxId)
    }
  )

  lazy val advance: Robot = copy(
    coordinates = bearing match {
      case Bearing.North => (coordinates._1, coordinates._2 + 1)
      case Bearing.East  => (coordinates._1 + 1, coordinates._2)
      case Bearing.South => (coordinates._1, coordinates._2 - 1)
      case Bearing.West  => (coordinates._1 - 1, coordinates._2)
    }
  )

  def simulate(commands: String): Robot = commands.foldLeft(this)(execute)

  private def execute(robot: Robot, command: Char) = {
    command match {
      case 'A' => robot.advance
      case 'R' => robot.turnRight
      case 'L' => robot.turnLeft
    }
  }

}