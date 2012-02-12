package com.sss.ch18


/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 08/02/12
 * Time: 14:23
 * To change this template use File | Settings | File Templates.
 */

object Ch18 extends App{


  val b = new BankAccount

  println("b.balance = " + b.balance)
  
  b deposit  100
  b withdraw 10

  println("b.balance = " + b.balance)
  
  
  val t = new Time
  t.hour = 1
  t.minute =12

  println("t = " + t)

  val temp = new Thermometer
  println("temp = " + temp)


}
