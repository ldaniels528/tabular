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
  def basicTables(): Unit = {
    val groceryList = Seq(
      GroceryItem("Milk"),
      GroceryItem("Eggs"),
      GroceryItem("Cheese"))

    val tabular = new Tabular()
    tabular.transform(groceryList) foreach(logger.info)
  }

  case class GroceryItem(name: String, quantity: Int = 1)

}
