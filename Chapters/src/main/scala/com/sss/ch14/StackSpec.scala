package com.sss.ch14

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 07/02/12
 * Time: 12:44
 * To change this template use File | Settings | File Templates.
 */
import org.scalatest.FlatSpec
import scala.collection.mutable.Stack

class StackSpec extends FlatSpec {

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    assert(stack.pop() === 2)
    assert(stack.pop() === 1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[String]
    intercept[NoSuchElementException] {
      emptyStack.pop()
    }
  }
}
