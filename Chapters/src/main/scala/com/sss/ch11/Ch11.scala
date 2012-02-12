package com.sss.ch11


/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 06/02/12
 * Time: 16:08
 * To change this template use File | Settings | File Templates.
 */

object Ch11 extends App {

  // At the top of the class hierarchy is Class Any
  // AnyVal and AnyRef
  //bottom of the hierarchy scala has  scala.Null and scala.Nothing
  //AnyRef is alias for java.lang.Object

  /* final def ==(that: Any): Boolean
final def !=(that: Any): Boolean
def equals(that: Any) : Boolean
def ##: Int
def hashCode: Int
def toString: String*/


  val x = "abcd"

  val y = new String("abcd")

  // works as expected.. unlike jva
  assert(x == y)

  val x1 = x substring 2

  val y1 = y substring 2

  //works
  assert(x1 == y1)

  //how check reference equality
  //AnyRef defines eq method, which cannot be overridden
  //which behaves like == in java for reference types
  val a = new String("abc")
  val b = new String("abc")

  assert(!(a eq b))
  assert(a ne b)


  //Bottom types
  // bottom of the hierarchy scala has  scala.Null and scala.Nothing

  //Class Null is the type the null reference --> is subclass of every reference class
  //Null is not compatible with value types. Yo cannot assign  a  null value to an Int variable

  //Type Nothing is at the very bottom of scala class hierarchy --> it is subtype of every other type.
  //However, there exist no values of this type whatsoever

  // Nothing is that signal for Abnormal termination . e.g sys.exit(1)    sys.error("Message")


  def divide(x: Int, y: Int) =
    if (y != 0) x / y
    else sys.error("can't divide by zero")

  // since nothing is subtype of every other type we can return it for every other type.

  //is equivalent to
  def divide1(x: Int, y: Int) =
    if (y != 0) x / y
    else throw new RuntimeException("can't divide by zero")




}

