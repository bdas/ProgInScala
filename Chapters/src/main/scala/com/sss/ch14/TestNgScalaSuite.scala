package com.sss.ch14

import org.scalatest.testng.TestNGSuite
import scala.collection.mutable.ListBuffer
import org.testng.annotations.{BeforeMethod, Test, Configuration}

class TestNgScalaSuite extends TestNGSuite {

  var sb: StringBuilder = _
  var lb: ListBuffer[String] = _

  @BeforeMethod
  def setUpFixture() {
    sb = new StringBuilder("ScalaTest is ")
    lb = new ListBuffer[String]
  }

  @Test(invocationCount = 3)
  def easyTest() {
    sb.append("easy!")
    assert(sb.toString === "ScalaTest is easy!")
    assert(lb.isEmpty)
    lb += "sweet"
  }

  @Test(groups = Array("com.mycompany.groups.SlowTest"))
  def funTest() {
    sb.append("fun!")
    assert(sb.toString === "ScalaTest is fun!")
    assert(lb.isEmpty)
  }
}