import scala.util.parsing.combinator._

object PunchesParser extends JavaTokenParsers {
  def punches: Parser[List[(Int, Int)]] = ???
}
