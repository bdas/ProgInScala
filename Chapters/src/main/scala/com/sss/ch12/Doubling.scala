package com.sss.ch12

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 06/02/12
 * Time: 22:29
 * To change this template use File | Settings | File Templates.
 */

//trait extends Abstract IntQueue, means that trait can only be mixed into a class that extends intQue
trait Doubling extends IntQueue {

  //abstract override is only allowed on  traits to indicate to the compiler
  // that method calls supper method on abstract which is bound at the runtime
  // and this trait can only be mixed in with class that extends IntQueue
  abstract override def put(x: Int) {
    super.put(2 * x)
  }

}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) {
    super.put(x + 1)
  }
}


trait Filtering extends IntQueue {
  abstract override def put(x: Int) {
    if (x >= 0) super.put(x)
  }
}