package com.sss.ch19

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 08/02/12
 * Time: 18:20
 * To change this template use File | Settings | File Templates.
 */

object Ch19 extends App {

 var q = Queue[Int](1,5,4,9,7)
  var n:Int = 10
  q = q enqueue 1
  q = q enqueue 5
  q = q enqueue 4
  q = q enqueue 2
  q = q enqueue n
  println("q = " + q)

  val c = new Cell[Int](1)

  println("c.get = " + c.get)

  val a1 = Array("add")
  val a2:Array[Any]= a1.asInstanceOf[Array[Any]]


  case class A(name:String)
  case class B(override val name:String) extends A(name)
  case class C(override val name:String) extends A(name)

  var queue = Queue[B]()

  queue = queue.enqueue(B("B1"))
  val q1: Queue[A] = queue.enqueue(C("C1"))



}
