package com.sss.ch9

import java.io.{PrintWriter, File}
import java.util.Date


/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 02/02/12
 * Time: 19:02
 * To change this template use File | Settings | File Templates.
 */

object Ch9 extends App {
  /**CONTROL ABSTRACTION **/

  //Higher order functions -> functions that takes another function as parameter
  // These functions enable us to create control abstraction -- intern reducing the code duplication

  val listNames = List("Andrew", "Ash", "Bhagavan", "Das")

  def matchWith(matcher: (String) => Boolean) =
    for {name <- listNames if matcher(name)} yield name

  println(matchWith(_ startsWith "A"))
  println(matchWith(_ endsWith "s"))
  println(matchWith(_ contains "h"))

  listNames.filter(_.startsWith("A"))

  listNames.exists(_.length > 10)

  //----------------
  /**CURRYING **/

  //non curried
  def plainOldSum(x: Int, y: Int) = x + y

  println(plainOldSum(1, 2))

  //curried
  def curriedSum(x: Int)(y: Int) = x + y

  println(curriedSum(1)(2))
  //when we invoke curriedSum, we get two traditional function invocation back to back
  // first invocation wth param x and returns function value for the second function.
  //second function takes int parameter y

  var a = curriedSum(1) _
  println(a(2))


  def twice(p: (Double => Double), x: Double) = p(p(x))

  println(twice(_ + 1, 5))

  //open a resource, operate on it, and then close it
  def withPrintWriter(file: File)(op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }


  withPrintWriter(new File("ch.txt")) {
    writer => writer.println(new Date())
  }
}