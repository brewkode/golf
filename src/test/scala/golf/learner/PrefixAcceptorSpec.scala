package golf.learner

import org.scalatest.FlatSpec
import org.scalatest.Matchers._

class PrefixAcceptorSpec extends FlatSpec {
  "PrefixAcceptor" should "build tree by accepting prefixes" in {
    val values = List("qxp12","qxp23","qxp34","qxp35","qxp25","qxp359","qxp3335")
    val acceptor = new PrefixAcceptor
    val tree = acceptor.buildTree(values)
    tree.children.size should be(1)
    println(tree.component)
    tree.component should be("qxp(12|2(3|5)|3+(4|59))")
  }

  it should "generate regex which has common prefix and suffix" in {
    val values = List("prod6094957-product",
      "prod6062198-product",
      "prod6092903-product",
      "prod6259298-product",
      "prod6259356-product"
    )

    val acceptor = new PrefixAcceptor
    val tree = acceptor.buildTree(values)
    tree.children.size should be(1)
    println(tree.component) // FIX ME. "-product" should

  }
}
