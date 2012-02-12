package com.sss.ch21

import java.awt.event.{ActionListener, ActionEvent}

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 11/02/12
 * Time: 21:52
 * To change this template use File | Settings | File Templates.
 */

object Ch21 extends App {

  implicit def asRunnable(func: () => Unit): Runnable = {
    new Runnable {
      def run() {
        func()
      }
    }
  }

  val th: Thread = new Thread(() => println("Inside thread..."))
  th.start()

  def worker() {
    println("I'm inside thread")
  }
  val t: Thread = new Thread(worker _)
  t.start()

  implicit def func2ActionListener(f: ActionEvent => Unit) =
    new ActionListener {
      def actionPerformed(event: ActionEvent) {
        f(event)
      }
    }

  def printS(seq: IndexedSeq[Char]) {
    println(seq.toList)
  }

  //implicit conversion from String to IndexedSeq
  printS("Hello world")

  //IMPLICIT CONVERSION TO AN EXPECTED TYPE
  //Whenever the compiler sees an X, but needs a Y, it will look for an implicit function that converts X to Y.

  // val i:Int = 3.5 //error: type mismatch;

  implicit def doubleToInt(x: Double) = x.toInt
  val i: Int = 3.5
  // you can bring conversion function outside the scope via an import or inheritance

  //CONVERTING THE RECEIVER

  //implicit conversion also apply to the receiver of a method call
  // the object on which the method is invoked
  // Advantages
  // 1. A smoother integration of new classes into existing class hierarchy
  // 2. Supports writing domain specific language within the language.

  // string obj.exists, String does not have a method named exists.
  // The compiler will try to insert conversions before giving up.
  // in case of String its converted into StringOps

  val m1 = Map(1 -> "One", 2 -> "Two")
  println("m1 = " + m1)
  //converted into
  val m2 = Map(Tuple2(1, "One"), Tuple2(2, "Two"))
  println("m2 = " + m2)

  // -> is not syntax. Instead -> is a method of ArrowAssoc, a class defined inside
  // the standard scala preamble(Predef)

  //IMPLICIT  PARAMETERS
  // compiler sometime replace someCall(a) with someCall(a)(b)
  // or new SomeClass(a) with new SomeClass(a)(b), thereby adding a missing 
  // parameter list to complete a function call.

  // For example, if someCall's missing last parameter list takes three parameters, the compiler might replace someCall(a)
  // with someCall(a)(b,c,d). 

  // For this usage, not only must inserted identifiers, such as b,c and d in (b,c,d) be marked implicit where they are defined,
  // but also the last parameter list in someClass's or someClass's definition must be marked implicit

  case class Prompt(preference: String)

  case class Drink(preference: String)

  object Greeter {
    def greet(name: String)(implicit prompt: Prompt, drink: Drink) {
      println("Welcome, " + name + ". The system is ready.")
      print("But while you work, ")
      println("why not enjoy a cup of " + drink.preference + "?")
      println(prompt.preference)
    }
  }

  implicit val prompt = Prompt("Yes, master>")
  implicit val drink = Drink("tea")

  Greeter.greet("Das")

  //VIEW BOUNDS

  def max[T <% Ordered[T]](x: List[T]) {
    // implementation
  }

}