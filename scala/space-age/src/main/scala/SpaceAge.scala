object OrbitalPeriodCoefficient {
  val Mercury = 0.2408467d
  val Venus   = 0.61519726d
  val Mars    = 1.8808158d
  val Jupiter = 11.862615d
  val Saturn  = 29.447498d
  val Uranus  = 84.016846d
  val Neptune = 164.79132d
}

case class SpaceAge(ageInSec: Long) {
  private val earthAge: Double = ageInSec / 31557600.0d

  val seconds:   Long   = ageInSec
  val onEarth:   Double = SpaceAgeForPlanet(1)
  val onMercury: Double = SpaceAgeForPlanet(OrbitalPeriodCoefficient.Mercury)
  val onVenus:   Double = SpaceAgeForPlanet(OrbitalPeriodCoefficient.Venus)
  val onMars:    Double = SpaceAgeForPlanet(OrbitalPeriodCoefficient.Mars)
  val onJupiter: Double = SpaceAgeForPlanet(OrbitalPeriodCoefficient.Jupiter)
  val onSaturn:  Double = SpaceAgeForPlanet(OrbitalPeriodCoefficient.Saturn)
  val onUranus:  Double = SpaceAgeForPlanet(OrbitalPeriodCoefficient.Uranus)
  val onNeptune: Double = SpaceAgeForPlanet(OrbitalPeriodCoefficient.Neptune)

  def SpaceAgeForPlanet(coefficent: Double ): Double = {
    "%.2f".format(earthAge / coefficent).toDouble
  }
}
