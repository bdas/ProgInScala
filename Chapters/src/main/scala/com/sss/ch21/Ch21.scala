package com.sss.ch21

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

  val th: Thread = new Thread(()=> println("Inside thread..."))
  th.start()

  def worker() {
    println("I'm inside thread")
  }
  val t: Thread = new Thread(worker _)
  t.start()



  var a = List(1,2,3,4)


}
