package com.sss.ch14

import com.sss.ch10.Element._
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 07/02/12
 * Time: 10:20
 * To change this template use File | Settings | File Templates.
 */

class ElementSuite extends FunSuite with ShouldMatchers {

  test("UniformElement") {
    val ele = elem('x', 2, 3)

    info("Need to implement it fully")
  }

  test("subtraction")(pending)

  test("IndexOutOfBounds") {
    val s = "Hi"
    val caught = intercept[IndexOutOfBoundsException] {
      s.charAt(-1)
    }

    expect("String index out of range: -1") {
      caught.getMessage
    }
  }

  test("withShouldMatchers") {
    val sum = 1 + 2

    sum should equal(3)
  }

}