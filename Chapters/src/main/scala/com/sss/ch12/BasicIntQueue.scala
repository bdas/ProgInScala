package com.sss.ch12

import collection.mutable.ArrayBuffer

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 06/02/12
 * Time: 22:10
 * To change this template use File | Settings | File Templates.
 */

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]

  def get() = buf.remove(0)

  def put(x: Int) = { buf += x }
}