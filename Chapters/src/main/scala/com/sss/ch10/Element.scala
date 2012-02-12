package com.sss.ch10

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 03/02/12
 * Time: 23:27
 * To change this template use File | Settings | File Templates.
 */

abstract class Element {
  def contents: Array[String]

  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length

}

object Element{
  def elem(contents:Char, width: Int, height: Int) = {}

}