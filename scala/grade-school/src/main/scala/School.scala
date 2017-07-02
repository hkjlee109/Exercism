import scala.collection.SortedMap

class School {
  var db:Map[Int, Seq[String]] = Map().withDefaultValue(Seq.empty)

  def add(name: String, n: Int) = {
    db += (n -> (db(n) :+ name))
  }

  def grade(n: Int): Seq[String] = db(n)

  def sorted = SortedMap(db.toSeq:_*) mapValues (_.sorted)
}