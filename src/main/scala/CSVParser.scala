import scala.util.parsing.combinator._

// parse a single line
object CSVParser extends RegexParsers{
  def plainString = "[^,]*".r ^^ identity
  def stringInQuotes = "\"" ~ "[^\"]*".r ~ "\"" ^^ {case _ ~ qstr ~ _ => qstr}
  def string = stringInQuotes | plainString
  def lastItem: Parser[List[String]] = string ^^ {str => List(str)}
  def moreItems: Parser[List[String]] = string ~ "," ~ line ^^ {case head ~ _ ~ tail => head :: tail}
  def line = moreItems | lastItem
}
