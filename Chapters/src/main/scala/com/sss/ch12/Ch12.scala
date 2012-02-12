package com.sss.ch12


/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 06/02/12
 * Time: 17:52
 * To change this template use File | Settings | File Templates.
 */

object Ch12 extends App {
  /*** TRAITS **/

  val frog = new Frog()
  frog.philosophise()

  //with companion object, apply method
  val f = Frog()
  f.philosophise()

  // trait also defines type.
  val phil: Philosophical = frog
  phil.philosophise()

  //if you wish to mix a trait into a class that extends a another class. use 'with' clause to mix in the trait
  // to mix in multiple traits, add more 'with' clauses

  //Facts
  //traits can declare field, methods  and maintain state. In fact , you can do anything in trait declaration  that you can do in the class definition 
  // traits can not have 'class'  parameters. ie. parameters passed to the primary constructors of a class

  // i.e
  class Pt(x: Int, y: Int)

  //will compile

  //trait HasPoint(x:Int,  y:Int) // wil not compile


  // in classes super calls are statically bound. In traits they dynamically bound
  //i.e  If you write super.toString  in a class, you know exactly which method implementation would be invoked.
  // when you write same thing in a trait, the method implementation to invoke for super class are undefined when declare the trait,
  // it will be determined  anew each time  the trait is mixed  into a class.


  val rect = new Rectangle(new Point(1, 1), new Point(10, 10))
  assert(rect.left == 1)
  assert(rect.right == 10)
  assert(rect.width == 9)

  // Trait as stackable modifications
  val q = new DoublingQueue
  q.put(10)

  assert(q.get() == 20)
  
  //or
  val queue = new BasicIntQueue with Doubling

  //traits further to right take effect first
  val smQ = new BasicIntQueue with Incrementing with Filtering
  smQ.put(-1); smQ.put(0); smQ.put(1)
  println(smQ.get())
  println(smQ.get())



}