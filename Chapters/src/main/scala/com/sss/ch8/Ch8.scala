package com.sss.ch8

import java.io.PrintStream
import compat.Platform

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 01/02/12
 * Time: 23:49
 * To change this template use File | Settings | File Templates.
 */

object Ch8 extends App {

  //FUNCTIONS AND CLOSURES
  //functions nested within the functions, function literals, function values

  // a function which is a member of some object is called as method


  //first class functions

  //define a function as unnamed literals and pass them around as values
  // function literals  & function value  (class at source code & object at runtime)

  //function literal is compiled into a class that when instantiated at runtime is a function value.

  //simple function literal, under-the-hood scala represents this using Function1 trait. ( Function0 to FunctionN where N is number of argument)
  (x: Int) => x + 1

  //function values are like objects. You can store them in a variable.
  var increment = (x: Int) => x + 1

  //  var increment =  _ + 1

  println(increment(10))
  // since increment function value is var we can reassign to any other function literal.
  increment = {
    println("We")
    println("are")
    println("here")
    _ + 1
  }
  println(increment(1))

  // bulit-in
  val someNumbers = List(-11, -10, -5, 0, 5, 10)
  //someNumbers.foreach((x: Int) => println(x))
  //someNumbers.foreach( x => println(x))
  //someNumbers.foreach( println( _ )) //placeholder syntax 
  //someNumbers.foreach(println _ )  // partially applied function, underscore in this case is not a placeholder for single param
  // It is a placeholder for entire param list 
  someNumbers.foreach(println)


  val filtered = someNumbers.filter(x => x > 0) //target typing
  //no need to say x is Int .. scala can infer. target typing
  println(filtered)

  println(someNumbers.filter(_ > 0))
  // placeholder syntax

  var ph = (_: Int) + (_: Int) //first _ is first param 2nd _ is 2nd param
  println(ph(1, 2))


  /**PARTIALLY APPLIED FUNCTIONS **/
  def sum(x: Int, y: Int, z: Int) = x + y + z

  val pFun = sum _
  //_ is used to convert regular method into function value. where sum is regular method and pFun is a function value

  println(pFun(1, 2, 3))

  val p2 = sum(1, _: Int, 3)

  println(p2(2))

  def fil(x: Int) = x > 5

  println(someNumbers.filter(fil))
  // we can leave off  the underscore here since argument to the filter is function literal

  /**CLOSURES **/
  var more = 10

  var c = (x: Int) => x + more
  // here x is bound variable and `more` is free variable available in the scope, out side the function literal

  // function value (object) created at runtime is called as closure

  //closure is open-term where as function literal in its pure form is closed-term.
  println(c(1))
  more = 100;
  // closure can capture changes made to free variable
  println(c(1))

  var sumNum = 0
  someNumbers.foreach(sumNum += _)
  //changes made by the closure are visible outside the closures
  println(sumNum)


  /**SPECIAL FUNCTION CALL **/
  // scala supports repeated  parameters, named arguments and default parameters

  //repeated parameters
  def echo(args: String*) =
    for (arg <- args) println(arg)

  echo()
  echo("one")
  echo("one", "two")

  val arr = Array("What's", "up", "doc?")
  echo(arr: _*)

  // : _* indicates to compiler to pass each element of array as argument

  //Named argument

  def speed(distance: Float, time: Float) =
    distance / time

  println(speed(100, 10))

  //with named param
  speed(time = 10, distance = 100)


  //default argument
  def printTime(out: PrintStream = Console.out) =
    out println Platform.currentTime

  // default argument wil be picked
  printTime()

  def printTime2(out: PrintStream = Console.out, divisor: Int = 1) =
    out println Platform.currentTime / divisor

  printTime2(divisor = 2)

  //-----------
  // tail recursion

  def gcd(x: Int, y: Int): Int =
    if (y == 0) x else gcd(y, x % y)

  // the recursive call is the last thing which happens in this function
  // such functions are called tail-recursive. and scala will optimise such code with while loop

  println(gcd(2, 5))

  //however though recursive call is the last statement,
  // this performs addition after recursive call, such call is not tail recursion
   def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)
   println(factorial(5))


}