package com.sss.ch20

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 09/02/12
 * Time: 19:49
 * To change this template use File | Settings | File Templates.
 */

abstract class CurrencyZone {

  type Currency <: AbstractCurrency

  val CurrencyUnit: Currency

  protected def make(amount: Long): Currency

  abstract class AbstractCurrency {

    val amount: Long

    def code: String

    def +(that: Currency): Currency =
      make(this.amount + that.amount)

    def -(that: Currency): Currency =
      make(this.amount - that.amount)

    def *(x: Double): Currency =
      make((this.amount * x).toLong)

    def from(other: CurrencyZone#AbstractCurrency): Currency =
      make(math.round(other.amount.toDouble * Converter.exchangeRate(other.code)(this.code)))

    private def decimals(n: Long): Int =
      if (n == 1) 0 else 1 + decimals(n / 10)

    override def toString =
      (amount.toDouble / CurrencyUnit.amount.toDouble) formatted ("%." + decimals(CurrencyUnit.amount) + "f") + " " + code
  }

}

object Converter {
  var exchangeRate = Map(
    "USD" -> Map("USD" -> 1.0, "EUR" -> 0.7596,
      "JPY" -> 1.211, "CHF" -> 1.223),
    "EUR" -> Map("USD" -> 1.316, "EUR" -> 1.0,
      "JPY" -> 1.594, "CHF" -> 1.623),
    "JPY" -> Map("USD" -> 0.8257, "EUR" -> 0.6272,
      "JPY" -> 1.0, "CHF" -> 1.018),
    "CHF" -> Map("USD" -> 0.8108, "EUR" -> 0.6160,
      "JPY" -> 0.982, "CHF" -> 1.0)

  )
}

object US extends CurrencyZone {

  abstract class Dollar extends AbstractCurrency {
    def code = "USD"
  }

  type Currency = Dollar
  protected def make(cents: Long) = new Dollar {
    val amount = cents
  }
  val Cent = make(1)
  val Dollar = make(100)
  val CurrencyUnit = Dollar

}

object EUR extends CurrencyZone {

  abstract class Euro extends AbstractCurrency {
    def code = "EUR"
  }

  type Currency = Euro
  protected def make(cents: Long) = new Euro {
    val amount = cents
  }
  val Cent = make(1)
  val Euro = make(100)
  val CurrencyUnit = Euro

}

