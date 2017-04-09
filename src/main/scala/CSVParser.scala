import scala.util.parsing.combinator._

// parse a single line
object CSVParser extends RegexParsers{
  def plainString = "[^,]*".r ^^ identity
  def stringInQuotes = "\"" ~ "[^\"]*".r ~ "\"" ^^ {case _ ~ qstr ~ _ => qstr}
  def string = stringInQuotes | plainString
  def line: Parser[List[String]] = (
    string ~ "," ~ line ^^ {case head ~ _ ~ tail => head :: tail}
    | string ^^ {str => List(str)}
  )
}
