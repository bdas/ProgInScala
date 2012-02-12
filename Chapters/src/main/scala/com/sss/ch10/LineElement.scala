package com.sss.ch10

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 04/02/12
 * Time: 00:38
 * To change this template use File | Settings | File Templates.
 */

class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def height = 1

  override def width = s.length


}