import scala.util.parsing.combinator._

object PunchesParser extends JavaTokenParsers {
  def number: Parser[Int] =  decimalNumber ^^ {_.toInt}

  def singlePunch: Parser[(Int, Int, Int)] = "[" ~ number ~ "," ~ number ~ "," ~ number ~ "]" ^^ {case _ ~ n1 ~ _ ~  n2 ~ _ ~ n3 ~ _ => (n1, n2, n3)}

  def punchSeq: Parser[List[(Int, Int, Int)]] =
      singlePunch ~ "," ~ punchSeq ^^ {case head ~ _ ~ tail => head :: tail} |
        singlePunch ^^ {head => List(head)}

  def punches: Parser[List[(Int, Int, Int)]] = "[" ~> punchSeq <~ "]"
}
