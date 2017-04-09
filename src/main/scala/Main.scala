import java.io._

object Main extends App {
  def extractPunches(controls: Seq[Int], punches: Seq[(Int, Int, Int)]): Seq[String] = {
    controls.map { cn =>
      punches.find(_._1 == cn).fold(""){ case (_, time, _) =>
        time.toString
      }
    }
  }

  val input = io.Source.fromFile("data/data.csv")

  val output = new java.io.FileOutputStream("data/data-out.csv")
  val writer = new OutputStreamWriter(output)

  try {
    val lines = input.getLines()
    val header = lines.next

    val controls = Seq(31, 32, 33, 34, 35)
    writer.write(header+"\n")

    for (line <- lines) {
      val parsed = CSVParser.parse(CSVParser.line, line)
      parsed match {
        case CSVParser.Success(values, _) =>
          val punches = values.lift(6).map { p =>
            val pp = PunchesParser.parse(PunchesParser.punches, p)
            pp match {
              case PunchesParser.Success(pps, _) =>
                extractPunches(controls, pps)
              case _ => throw new UnsupportedOperationException(s"Error parsing punches `$p`")
            }
          }

          println(punches)
          val lineOut = values.patch(6, punches.toSeq.flatten, 1)

          writer.write(lineOut.mkString(",")+"\n")
        case _ =>
      }
    }
  } finally {
    writer.close()
    output.close()
  }


}
