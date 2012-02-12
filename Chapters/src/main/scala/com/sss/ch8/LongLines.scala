package com.sss.ch8

import io.Source
import java.lang.String

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 02/02/12
 * Time: 00:01
 * To change this template use File | Settings | File Templates.
 */

object LongLines {

  def processFile(filename: String, width: Int) {

    //function within function
    def processLine(line: String) {
      if (line.length > width)
        println(filename + ":" + line.trim)
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines)
      processLine(line)
  }

  //helper function.
  // in scala this ca be defined as function within function just like local variable
  // such functions  only visible  in their enclosing blocks

  /*private def processLine(filename: String, width: Int, line: String) {
    if (line.length > width)
      println(filename + ":" + line.trim)
  }*/
}