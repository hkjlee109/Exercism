class DNA(genomes: String) {
  val genomeType = "ATCG"
  val dna: Map[Char, Int] = genomes groupBy (_.toChar) mapValues (_.size)

  validate(genomes)

  def nucleotideCounts(): Map[Char, Int] = {
    for {
      genome <- genomeType
    } yield (genome -> nucleotideCounts(genome))
  }.toMap

  def nucleotideCounts(elem: Char): Int = {
    validate(elem.toString)
    dna getOrElse (elem, 0)
  }

  def validate(param: String) = {
    if ((param forall (c => genomeType.contains(c))) == false)
      throw new RuntimeException("Error")
  }
}
