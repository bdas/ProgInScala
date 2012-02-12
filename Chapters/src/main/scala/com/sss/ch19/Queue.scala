package com.sss.ch19


/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 08/02/12
 * Time: 18:42
 * To change this template use File | Settings | File Templates.
 */

class Queue[+T] private(
                         private[this] var leading: List[T],
                         private[this] var trailing: List[T]
                         ) {
  //def this(e:T*) = this(e.toList, Nil)

  private def mirror {
    if (leading.isEmpty) {
      while (!trailing.isEmpty) {
        leading = trailing.head :: leading
        trailing = trailing.tail
      }
    }
  }

  def head: T = {
    mirror
    leading.head
  }

  def tail: Queue[T] = {
    mirror
    new Queue[T](leading.tail, trailing)
  }

  def enqueue[U >: T](x: U) =
    new Queue[U](leading, x :: trailing)

  override def toString = {
    leading.mkString("Queue" + "(", ", ", "") +
      trailing.reverse.mkString("", ", ", ")")
  }


}


object Queue {
  def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)
}

