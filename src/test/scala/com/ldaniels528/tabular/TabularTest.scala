package com.ldaniels528.tabular

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

  case class GroceryItem(item: String, quantity: Int = 1, requestedBy: String)

}
