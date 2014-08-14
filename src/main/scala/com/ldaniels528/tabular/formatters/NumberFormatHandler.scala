package com.ldaniels528.tabular.formatters

import com.ldaniels528.tabular.Tabular

/**
 * Number Format Handler
 * @author lawrence.daniels@gmail.com
 */
trait NumberFormatHandler extends FormatHandler {
  self: Tabular =>
  type DecimalLike = {def toDouble: Double}

  // attach thyself
  self += this

  /**
   * Indicates whether this handler understands how to format the given value
   * @param value the given value
   * @return true, if the value is handled by this instance
   */
  override def handles(value: Any): Boolean = value match {
    case n: DecimalLike => true
    case _ => false
  }

  /**
   * Formats the given value
   * @param value
   * @return
   */
  override def format(value: Any): Option[String] = {
    import java.text.NumberFormat

    value match {
      case n: DecimalLike => Some(NumberFormat.getInstance().format(n.toDouble))
      case _ => None
    }
  }

}
