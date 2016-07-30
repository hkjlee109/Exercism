case class Atbash() {
  private val number = ('0' to '9').toList
  private val plain = ('a' to 'z').toList
  private val cipher = plain.reverse
  private val cipherCheatSheet = ((plain:::number) zip (cipher:::number)) toMap

  def encode(s: String) = {
    val answer = (s.filter(_.isLetterOrDigit).toLowerCase) map cipherCheatSheet
    answer grouped(5) mkString (" ")
  }
}
