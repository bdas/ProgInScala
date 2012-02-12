package com.sss.ch14

import org.scalatest.junit.JUnitSuite
import collection.mutable.ListBuffer
import org.junit.{Test, Before}

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 07/02/12
 * Time: 12:20
 * To change this template use File | Settings | File Templates.
 */

class JunitScalaSuite extends JUnitSuite {

  var sb: StringBuilder = _
  var lb: ListBuffer[String] = _

  @Before def initialize() {
       sb = new StringBuilder("ScalaTest is ")
       lb = new ListBuffer[String]
     }

  @Test def verifyEasy() {
       sb.append("easy!")
       assert(sb.toString === "ScalaTest is easy!")
       assert(lb.isEmpty)
       lb += "sweet"
     }

  @Test def verifyFun() {
       sb.append("fun!")
       assert(sb.toString === "ScalaTest is fun!")
       assert(lb.isEmpty)
     }
}
