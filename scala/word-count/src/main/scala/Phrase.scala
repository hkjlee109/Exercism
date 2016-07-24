class Phrase(s: String) {
  private val msg = s.split("[ .,:!&@$%^]+")

  def wordCount = {
    msg.groupBy(_.toLowerCase).mapValues(_.length)
  }
}
