package com.sss.ch12

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 06/02/12
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 */
class Point(val x: Int, val y: Int)

trait Rectangular {

  def topLeft: Point

  def bottomRight: Point

  def left = topLeft.x

  def right = bottomRight.x

  def width = right - left
}

class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular {

}
