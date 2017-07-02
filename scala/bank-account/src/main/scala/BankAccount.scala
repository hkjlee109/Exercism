case class BankAccount() {
  private var balance: Option[Int] = Some(0)

  def getBalance = balance
  def closeAccount() = { balance = None }
  def incrementBalance(saving: Int) = { synchronized(balance = balance map (_ + saving)); balance }
}
