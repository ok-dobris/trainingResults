import java.io._

object Main extends App {
  def extractPunches(controls: Seq[Int], punches: Seq[Int]) = ???

  val input = io.Source.fromFile("data/data.csv")

  val output = new java.io.FileOutputStream("data/data-out.csv")
  val writer = new OutputStreamWriter(output)

  try {
    val content = input.getLines().drop(1) // drop header

    for (line <- content) {
      val parsed = CSVParser.parse(CSVParser.line, line)
      parsed match {
        case CSVParser.Success(values, _) =>
          val lineOut = values.mkString("#")
          val punches = values.lift(6).map { p =>
            PunchesParser.parse(PunchesParser.punches, p)
          }

          println(punches)


          writer.write(lineOut+"\n")
        case _ =>
      }
    }
  } finally {
    writer.close()
    output.close()
  }


}
