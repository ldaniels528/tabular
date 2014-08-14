package com.ldaniels528.tabular

import org.junit.Test
import org.slf4j.LoggerFactory

/**
 * Tabular Test Suite
 * @author lawrence.daniels@gmail.com
 */
class TabularTest {
  private val logger = LoggerFactory.getLogger(getClass)

  @Test
  def basicTable() {
    val groceryList = Seq(
      GroceryItem("Milk", requestedBy = "kids"),
      GroceryItem("Eggs", requestedBy = "Mom"),
      GroceryItem("Cheese", requestedBy = "Mom"),
      GroceryItem("Beer", requestedBy = "Dad"))

    val tabular = new Tabular()
    tabular.transform(groceryList) foreach logger.info
  }

  case class GroceryItem(item: String, quantity: Int = 1, requestedBy: String)

}
