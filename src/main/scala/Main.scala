import java.io._

object Main extends App {
  def extractPunches(controls: Seq[Int], punches: Seq[(Int, Int, Int)]): Seq[String] = {
    controls.map { cn =>
      punches.find(_._1 == cn).fold(""){ case (_, time, _) =>
        time.toString
      }
    }
  }

  def minsec(t: Int) = {
    val m = t / 60
    val s = t - m * 60
    f"$m:$s%02d"
  }

  def timeElapsed(time: Int, start: Int): String = {
    // modulo 12 hours - some times are 12 h only?
    var delta = time - start
    val modulo = 12*3600
    while (delta < 0) delta += modulo
    while (delta > modulo) delta -= modulo
    minsec(delta)
  }

  val input = io.Source.fromFile("data/data.csv")

  val output = new java.io.FileOutputStream("data/data-out.csv")
  val writer = new OutputStreamWriter(output)

  try {
    val lines = input.getLines()
    val header = lines.next

    val controls = Seq(31, 32, 33, 34, 35)
    //writer.write(header+"\n")

    for (line <- lines) {
      val parsed = CSVParser.parse(CSVParser.line, line)
      parsed match {
        case CSVParser.Success(values, _) =>
          val pp = PunchesParser.parse(PunchesParser.punches, values(6))
          val punches = pp match {
            case PunchesParser.Success(pps, _) =>
              extractPunches(controls, pps)
            case _ => throw new UnsupportedOperationException(s"Error parsing punches `$pp`")
          }


          val startTime = values(4).toInt
          val finishTime = timeElapsed(values(5).toInt, startTime)

          val punchTimes = punches.map { t =>
            if (t.nonEmpty) timeElapsed(t.toInt, startTime)
            else ""
          }
          println(punchTimes)

          val lineOut = values.patch(6, punchTimes, 1).patch(5, Seq(finishTime), 1).patch(4, Nil, 1)


          writer.write(lineOut.mkString(",")+"\n")
        case _ =>
      }
    }
  } finally {
    writer.close()
    output.close()
  }


}
