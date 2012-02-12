package com.sss.ch17

import collection.mutable.{ArrayBuffer, ListBuffer}
import collection.mutable


/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 08/02/12
 * Time: 10:12
 * To change this template use File | Settings | File Templates.
 */

object Ch17 extends App {


  // Sequences

  // List - supports fast addition  and removal of items to the beginning of the list.
  // do not provide fast access to arbitrary indexes  because the implementation must  iterate through the list linearly


  //Arrays
  // Arrays allow you to hold a sequence of elemnts and efficiently access an element at an arbitrary
  // position, both to get or update the element, with zero based index.
  val fiveInts = new Array[Int](5) // array filled with zeros
  val dim5: Array[Int] = Array.ofDim[Int](5)
  val fiveToOne = Array(5, 4, 3, 2, 1)

  // sclaa array obeys variance


  //List Buffers
  // Class List provides fast access to the head of the list, but not the end. ( .last  .init)

  //ListBuffer is a mutable object, which can help you to build the list more efficiently
  // when you need to append. it provides constant time append and prepend operation

  // append +=
  //prepend +=:
  //when you are done u can call .toList

  val buf = new ListBuffer[Int]
  buf += 1
  buf += 2
  0 +=: buf

  println(buf.toList)

  //ArrayBuffer
  // All array operations are available, bit slower due to a layer of wrapping in the 
  // implementation. 
  val abuf = new ArrayBuffer[Int]
  abuf += 1
  abuf += 2
  0 +=: abuf

  println(abuf.toList)


  //Strings ( via StringOps)
  // Predef has implicit conversion from string to StringOps
  // thus you can treat string like a sequence
  println("Das".exists(_.isUpper))


  //SETS AND MAPS
  val s = Set(1, 2, 3)
  val m = Map(1 -> 1, 2 -> 2)


  val text = """The regular expression "[ !,.]+ will suffice: See Spot run. Run, Spot. Run! """

  val wArray: Array[String] = text.split("[ !,.]+")
  val words = mutable.Set.empty[String]

  for (word <- wArray) {
    words += word.toLowerCase
  }

  println("words = " + words)

  val map = mutable.Map.empty[String, Int]

  map("hello") = 1
  map("there") = 2
  println("map = " + map)

  //SORTED SETS and MAPS



}
