import scala.annotation.tailrec
import java.util.Calendar
import java.util.GregorianCalendar

object Meetup extends Enumeration {
  val Sun, Mon, Tue, Wed, Thu, Fri, Sat = Value
}

case class Meetup(month: Int, year: Int) {
  private val calendar = new GregorianCalendar(year, month - 1, 1)

  def first (day: Meetup.Value): GregorianCalendar = CalendarForGivenDay(1 + 7 * 0, day)
  def second(day: Meetup.Value): GregorianCalendar = CalendarForGivenDay(1 + 7 * 1, day)
  def third (day: Meetup.Value): GregorianCalendar = CalendarForGivenDay(1 + 7 * 2, day)
  def fourth(day: Meetup.Value): GregorianCalendar = CalendarForGivenDay(1 + 7 * 3, day)
  def last  (day: Meetup.Value): GregorianCalendar = CalendarForGivenDay(1 + 7 * 4, day)
  def teenth(day: Meetup.Value): GregorianCalendar = CalendarForGivenDay(13, day)

  @tailrec
  private def CalendarForGivenDay(startDayOfMonth: Int, expectedDayOfWeek: Meetup.Value): GregorianCalendar = {
    calendar.set(Calendar.DAY_OF_MONTH, startDayOfMonth)
    calendar.get(Calendar.DAY_OF_WEEK) match {
      case day if (day == expectedDayOfWeek.id + 1) => { MakeSureThatTheDayIsWithinTheExpectedMonth(); calendar }
      case _ => CalendarForGivenDay(calendar.get(Calendar.DAY_OF_MONTH) + 1, expectedDayOfWeek)
    }
  }

  private def MakeSureThatTheDayIsWithinTheExpectedMonth() = {
    calendar.get(Calendar.MONTH) match {
      case currentMonth if (currentMonth == month - 1) => None
      case _ => calendar.add(Calendar.WEEK_OF_YEAR, -1)
    }
  }
}
