package com.sss.ch19

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 08/02/12
 * Time: 20:31
 * To change this template use File | Settings | File Templates.
 */

class Cell[T](init: T) {
  private[this] var current = init

  def get = current

  def set(x: T) {
    current = x
  }

}
