object Plant extends Enumeration {
  val Radishes, Clover, Grass, Violets = Value
}

case class Garden(children: List[String], layout: String) {
  private val plantAbbrMap = Map('R' -> Plant.Radishes, 'C' -> Plant.Clover, 'G' -> Plant.Grass, 'V' -> Plant.Violets)

  private val Array(firstRowPlantsCode, secondRowPlantsCode) = layout.split("\n")
  private val firstRowPlantsList = (firstRowPlantsCode map plantAbbrMap).toList
  private val secondRowPlantsList = (secondRowPlantsCode map plantAbbrMap).toList

  private val plantToChildrenMap1 = helperGetPlantAndPlantOwnerList(firstRowPlantsList, children.sorted)
  private val plantToChildrenMap2 = helperGetPlantAndPlantOwnerList(secondRowPlantsList, children.sorted)

  def getPlants(child: String) = {
    for (
      (plant, name) <- plantToChildrenMap1 ::: plantToChildrenMap2
      if (name == child)
    ) yield plant
  }

  private def helperGetPlantAndPlantOwnerList(plantList: List[Plant.Value], childList: List[String]) = {
    for (
      (plant, i) <- plantList zipWithIndex
    ) yield (plant, childList(i/2))
  }

}

object Garden {

  val defaultChildren = List("Alice", "Bob", "Charlie", "David",
                             "Eve", "Fred", "Ginny", "Harriet",
                             "Ileana", "Joseph", "Kincaid", "Larry")

  def defaultGarden(layout: String) = Garden(defaultChildren, layout)

}