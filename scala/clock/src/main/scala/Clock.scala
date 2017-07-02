import Clock._

case class Clock(h: Int, m: Int) {
  private val time = getTimeInMinute(h, m)

  private val hour   = time / 60
  private val minute = time % 60

  def - (that: Clock): Clock = new Clock(this.hour - that.hour, this.minute - that.minute)
  def + (that: Clock): Clock = new Clock(this.hour + that.hour, this.minute + that.minute)

  override def toString = f"$hour%02d:$minute%02d"
  override def equals(that: Any): Boolean = if (that.isInstanceOf[Clock]) {
                                               (that.asInstanceOf[Clock]).time == time
                                            } else false
}

object Clock {
  def apply(m: Int) = new Clock(0, m)

  private def getTimeInMinute(h: Int, m: Int) = {
    (h * 60 + m) match {
      case x if (x < 0) => (60 * 24) + (x % (60 * 24))
      case x            => x % (60 * 24)
    }
  }
}