package com.sss.ch12

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 06/02/12
 * Time: 18:22
 * To change this template use File | Settings | File Templates.
 */
class Animal

class Frog extends Animal with Philosophical with HasLegs{
  override def toString = "green"

  override def philosophise() = println("It ain't easy being "+  toString +"!")
}

object Frog{

  def apply() = new Frog()
}