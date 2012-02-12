package com.sss.lang

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 30/01/2012
 * Time: 23:24
 * To change this template use File | Settings | File Templates.
 */
object Rational {
  println("Companion object was initialised")
  //implicit conversion
  implicit def intToRational(x: Int) = new Rational(x)

}

class Rational(n: Int, d: Int) extends Ordered[Rational] {

  require(d != 0, "Denominator of rational number cannot be zero.")

  private val gcd = MathUtil.findGcd(n.abs, d.abs)

  val numerator: Int = n / gcd
  val denominator: Int = d / gcd

  //Auxilary constructor
  def this(n: Int) = this(n, 1)

  def +(that: Rational) =
    new Rational(
      numerator * that.denominator + denominator * that.numerator,
      denominator * that.denominator)

  //operator overloading
  def +(that: Int) =
    new Rational(numerator + denominator * that, denominator)

  def -(that: Rational): Rational =
    new Rational(
      numerator * that.denominator - denominator * that.numerator,
      denominator * that.denominator)

  def -(that: Int): Rational =
    this - new Rational(that)

  def *(that: Rational): Rational =
    new Rational(
      numerator * that.numerator,
      denominator * that.denominator
    )

  def *(that: Int): Rational =
    new Rational(numerator * that, denominator)

  def /(that: Rational): Rational =
    new Rational(numerator * that.denominator,
      denominator * that.numerator
    )

  def /(that: Int): Rational =
    new Rational(numerator, denominator * that)

  def max(that: Rational) = if (this < that) that else this

  //unary operator method literal
  def unary_- =
    new Rational(-numerator, denominator)

  override def toString =
    if (denominator == 1) numerator.toString else numerator + "/" + denominator

  //override def hashCode() = 0

  //override def equals(p1: AnyRef) = false

  def compare(that: Rational) = numerator * that.denominator - that.numerator * this.denominator
}