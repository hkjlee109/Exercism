object Pangrams
{
  def isPangram(s: String): Boolean = {
    ('a' to 'z') forall (c => s.toLowerCase.contains(c))
  }
}
