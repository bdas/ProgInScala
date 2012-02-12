package com.sss.ch18

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 08/02/12
 * Time: 15:49
 * To change this template use File | Settings | File Templates.
 */

class Time {

  //var hour = 12
  var minute = 0
  private[this] var h = 12

  def hour = h

  def hour_=(x: Int) = {
    require(x >= 0 && x <= 24)
    h = x
  }

  override def toString = hour + ":" + minute
}


class Thermometer {
  var celsius: Float = _

  def fahrenheit = celsius * 9 / 5 + 32

  def fahrenheit_=(t: Float) = (t - 32) * 5 / 9

  override def toString = fahrenheit + "F/" + celsius + "C"
}
