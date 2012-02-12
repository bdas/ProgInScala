package com.sss.ch20

import com.sss.ch20.US.Dollar

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 09/02/12
 * Time: 19:48
 * To change this template use File | Settings | File Templates.
 */

object Ch20 extends App {

  val currency =  EUR.Euro from  US.Dollar * 100
  
  println("currency = " + currency)

}
