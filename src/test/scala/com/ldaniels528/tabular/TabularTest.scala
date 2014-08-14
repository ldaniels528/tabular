package com.ldaniels528.tabular

import com.ldaniels528.tabular.formatters.NumberFormatHandler
import org.junit.Test
import org.slf4j.LoggerFactory

/**
 * Tabular Test Suite
 * @author lawrence.daniels@gmail.com
 */
class TabularTest {
  private val logger = LoggerFactory.getLogger(getClass)

  /**
   * Generates a basic table from a case class.
   *
   * Expected output:
   * + ------------------------------- +
   * | item    quantity  requestedBy   |
   * + ------------------------------- +
   * | Milk    1         kids          |
   * | Eggs    1         Mom           |
   * | Cheese  1         Mom           |
   * | Beer    12        Dad           |
   * + ------------------------------- +
   */
  @Test
  def basicTable() {
    val groceryList = Seq(
      GroceryItem("Milk", requestedBy = "kids"),
      GroceryItem("Eggs", requestedBy = "Mom"),
      GroceryItem("Cheese", requestedBy = "Mom"),
      GroceryItem("Beer", quantity = 12, requestedBy = "Dad"))

    val tabular = new Tabular()
    tabular.transform(groceryList) foreach logger.info
  }

  @Test
  def usingFormatters() {
    val scores = Seq(
      Score("Lawrence", 5000),
      Score("Stan", 6500),
      Score("Cullen", 5700))

    val tabular = new Tabular() with NumberFormatHandler
    tabular.transform(scores) foreach logger.info
  }

  case class GroceryItem(item: String, quantity: Int = 1, requestedBy: String)

  case class Score(name: String, score: Int)

}
