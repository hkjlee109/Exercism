object Allergen extends Enumeration {
  val Eggs, Peanuts, Shellfish, Strawberries, Tomatoes, Chocolate, Pollen, Cats = Value
}

case class Allergies() {

  def isAllergicTo(allergen: Allergen.Value, state: Int): Boolean = {
    (1 << allergen.id & state) > 0
  }

  def allergies(state: Int): List[Allergen.Value] = {
    for (
      id <- (0 until Allergen.maxId);
      allergen = Allergen.apply(id)
      if(isAllergicTo(allergen, state))
    ) yield allergen
  }.toList

}
