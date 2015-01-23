package golf.learner

trait Node {
  def component: String
  def s(components: List[String]) = {
    val str = components.mkString("|")
    if(components.size > 1)
      s"($str)"
    else
      str
  }
}
case class Root(children: List[Node]) extends Node {
  override def component: String = s(children.map(_.component))
}
case class INode(symbol: Char, prefixes: Set[String], children: List[Node]) extends Node {
  def hasLoop = prefixes.size > 1
  def repeats = if(prefixes.size > 1) "+" else ""
  override def component: String = s"$symbol$repeats${s(children.map(_.component))}"
}
case class Leaf(symbol: Char, prefixes: Set[String]) extends Node {
  def repeats = if(prefixes.size > 1) "+" else ""
  override def component: String = s"$symbol$repeats"
}