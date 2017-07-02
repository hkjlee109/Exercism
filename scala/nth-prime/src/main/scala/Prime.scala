//object Prime {
//
//
//
//
//  private def isPrime(n: Int): Boolean= (2 to (n - 1)).forall(n % _ != 0)
//  private def searchPrime(n:Int, until: Int, found: Int): Int = {
//    if (found == until) return (n - 1)
//    if (isPrime(n))     { searchPrime(n + 1, until, found + 1) }
//    else                { searchPrime(n + 1, until, found) }
//  }
//
//  def nth(n: Int) = searchPrime(2, n, 0)
//}




object Prime {

  //Naive solution, not very efficient

  def nth(nth: Int): Int = prime drop nth - 1 head

  private def prime: Stream[Int] = 2 #:: Stream.from(3).filter(isPrime)

  private def isPrime(n: Int): Boolean = (2 until n) forall (x => n % x != 0)
}