package golf.learner

import org.apache.commons.lang3.StringUtils


class PrefixAcceptor {
  def startSymbols(input: List[String]) = {
    input.map(_.head).toSet
  }

  def suffixFor(input: List[String])(prefix: Char) = {
    input.filter(_.head == prefix).map(i => i.dropWhile(_ == prefix)).filter(StringUtils.isNotBlank)
  }

  def prefixesFor(input: List[String])(symbol: Char) = {
    input.map(_.takeWhile(_ == symbol)).filter(StringUtils.isNotBlank).toSet
  }

  def createTree(values: List[String]) : List[Node] = {
    val symbols = startSymbols(values)
    symbols.map{ symbol =>
      val suffixes = suffixFor(values)(symbol)
      val prefixes = prefixesFor(values)(symbol)

      if (suffixes.size > 0)
        INode(symbol, prefixes, createTree(suffixes))
      else
        Leaf(symbol, prefixes)
    }.toList
  }

  def buildTree(values: List[String]) = {
    Root(createTree(values))
  }
}