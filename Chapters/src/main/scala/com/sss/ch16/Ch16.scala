package com.sss.ch16

import collection.immutable.{IndexedSeq, List}


/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 07/02/12
 * Time: 19:02
 * To change this template use File | Settings | File Templates.
 */

object Ch16 extends App {

  // By default List's are immutable
  //List are homogeneous like array -> the elements of list have same type
  val num = List(1, 2, 3)
  //same as
  val numT: List[Int] = List(1, 2, 3)

  // == works naturally on list.. scala by design delegates == to equals method
  assert(num == numT)

  //they are not same by reference
  assert(num ne numT)

  // The list type in scala is covariant.
  //i.e for each pair of type S and T, if S is a subtype of T, then List[S] is subtype of List[T]

  // List[String] is subtype of List[Object]

  var empty: List[Nothing] = List()
  //empty list has type List{Nothing]
  //since Nothing is subtype of every other scala type and because of covariant, it follows that list{nothing]
  // is s subtype of List[T], for any T

  //List() is also of type List[String]
  val xs: List[String] = List()

  // all lists are built from 2 fundamental building blocks, Nil and :: (cons)
  // Nil represents the empty List. The infix operator :: expresses list extension at the front

  val fruits = "apples" :: "oranges" :: "pears" :: Nil

  println(fruits)

  val dia3 = (1 :: 0 :: 0 :: Nil) :: (0 :: 1 :: 0 :: Nil) :: (0 :: 0 :: 1 :: Nil) :: Nil
  println(dia3)


  // head -  returns the first element of a list
  // tail - returns a list consisting of all elements except the first
  // isEmpty

  // head and tail will throw NoSuchElementException when called on empty list


  /**LIST PATTERNS **/
  // List(...) wil match all the elements of a list

  //for exact 3 match, else would throw scala.MatchError at runtime
  val List(a, b, c) = fruits

  //or
  val x :: y :: rest = fruits

  println(x)
  println(y)
  println(rest)

  //there exists a class :: in scala pacakge i.e scal.::
  // also there is a mthod :: on List

  //The pattern x :: y is special case of infix operation pattern
  // x :: y  is equivalent to constructor ::(x,y)
  val ::(t, ::(x1, y1)) = fruits
  println(t)
  println(x1)
  println(y1)


  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case Nil => List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }

  def iSort(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case x :: xs1 => insert(x, iSort(xs1))
  }

  println(iSort(List(34, 4, 1)))

  //Concatenating 2 lists
  var cl = List(1, 2, 3) ::: List(4, 5, 6)
  println(cl)


  // init and last
  val abcde = List('a', 'b', 'c', 'd', 'e')
  abcde.last // 'e'
  abcde.init // a b c d

  abcde.reverse

  //drop take  and splitAt

  // flatten
  val fl: List[Int] = List(List(1, 2), List(3, 4), List(), List(5)).flatten

  println(fruits.map(_.toCharArray).flatten)

  //zip and unzip
  val seq: IndexedSeq[(Int, Char)] = abcde.indices zip abcde

  val zipped = abcde zip List(1, 2, 3) // id 2 lists of the different lengths, unmatched items are dropped

  val l: List[(Char, Int)] = abcde zipWithIndex

  val tl: (List[Char], List[Int]) = zipped unzip




}
