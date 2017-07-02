import java.util.{Calendar, GregorianCalendar}

case class Gigasecond(cal: GregorianCalendar) {
  val date: GregorianCalendar = { cal.add(Calendar.SECOND, 1000000000); cal }
}
