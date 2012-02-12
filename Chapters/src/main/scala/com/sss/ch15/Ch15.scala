package com.sss.ch15

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 07/02/12
 * Time: 14:08
 * To change this template use File | Settings | File Templates.
 */

object Ch15 extends App {
  // no need to use new
  val v = Var("x")
  val expr = BinOp("+", Number(1), v)

  //compiler adds natural implementation of toString, hasCode and equals
  println(v)
  //can access name field without declaring them as val in case class
  println(v.name)

  println(expr)
  println(expr.left)
  println(expr.right)


  //since == in scala always delegates to 'equals', they can be compared structurally
  println(expr.right == Var("x"))

  // compilers adds copy methods to case classes for making modified copies
  val opCopy = expr.copy(operator = "-") //copy op with given property change
  println(opCopy)

  /*** PATTERN MATCHING **/

  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("*", e, Number(1)) => e
    case _ => expr

  }

  println(simplifyTop(BinOp("+", v, Number(0))))


  //wildcard pattern. ( _ ) matches any object is wildcard
  expr match {
    case BinOp(_, _, _) => println(expr + " is a binary operation")
    case _ =>
  }

  //CONSTANT PATTERNS
  //constant pattern matches only itself .  Any literal may be used as a constant. e.g. 5, true "hello"
  // val and and singleton objects can be used as a constants
  //Nil a  singleton object, is a pattern that  matches only  the empty list

  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty list"
    case _ => "Something else"
  }

  println(describe(List()))

  //VARIABLE PATTERN
  //A variable patter matches any object, just like a wildcard.
  //Unlike wildcard scala binds the variable to whatever the objectis.

  val rst = 1 match {
    case 0 => "zero"
    case somethingElse => "not zero: " + somethingElse
  }

  println(rst)

  //Variable or Constants
  // Scala uses lexical rule for disambiguation.
  //if name starts with lowercase letter then it is taken as pattern variable; all other treated to be  contstants

  import math._

  println(E match {
    case Pi => "strange math? Pi= " + Pi
    case _ => "OK"
  })

  val pi = Pi

  println(E match {
    case pi => "strange math? Pi= " + Pi
    //case _ => "OK" //unreachable code
  })

  //back ticks can be used pick lowercase constants
  println(E match {
    case `pi` => "strange math? Pi= " + Pi
    case _ => "OK"
  })


  //CONSTRUCTOR PATTERNS
  val binaryExpr = BinOp("+", Number(1), Number(2))
  binaryExpr match {
    case BinOp("+", e, Number(2)) => println("a deep match")
    case _ =>
  }

  //SEQUENCE PATTERNS
  // you cam match against seq types like Array or List just like case classes

  var seqL = List(1, 2, 3)
  seqL match {
    case List(1, _, _) => println("its a List")
    case _ =>
  }

  seqL match {
    case List(1, _*) => println("its a List")
    case _ =>
  }

  // TUPLE PATTERN
  (1, 2, 3) match {
    case (a, b, c) => println("Its tuple" + a + b + c)
  }


  //TYPED PATTERNS
  def genericSize(x: Any): Int = x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
  }

  println(genericSize("asdf"))
  println(genericSize(Map(1 -> 'a', 2 -> 'b')))


  "asd".isInstanceOf[String]
  val s = "asd".asInstanceOf[String]

  //TYPE ERASURE
  def isIntIntMap(x: Any) = x match {
    case m: Map[Int, Int] => true
    case _ => false
  }

  //will not work due to Type erasure
  println(isIntIntMap(Map(1 -> "2", 2 -> "4")))

  //Array is exception .. element type of array is store
  def isStriingArray(x: Any) = x match {
    case a: Array[String] => "Y"
    case _ => "N"
  }

  println(isStriingArray("A"))
  println(isStriingArray(Array("A")))


  //VARIABLE BINDING
  val absOp = UnOp("abs", UnOp("abs", Number(-1)))
  println(absOp match {
    case UnOp("abs", e@UnOp("abs", _)) => e
    case _ => absOp
  })


  /*** PATTERN GUARDS **/
  //patten gaurd comes after patten and starts with if
  def simplifyAdd(e: Expr): Expr = e match {
    case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
    case _ => e
  }

  //where x == y is pattern guard
  //e.g.
  // case n: Int  if 0 < n => ...
  // case s: String if s(0) == 'a' => ...


  //use @unchecked to shut the compiler not generate warning for not exhaustive case
  def describe(e: Expr): String = (e: @unchecked) match {
    case Number(_) => "a number"
    case Var(_) => "a varibale"
  }


  /**OPTION TYPE**/

  val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
  val o1: Option[String] = capitals get "France" //which is Some(Paris)

  println(o1)

  val o2 = capitals get "North Pole"
  println(o2)

  // None

  //common way to take optional  values apart is through a pattern matching
  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }
  println(show(o2))

  // Patterns in variable  definition
  
  val mt = (123,"abc")
  val (num,str) = mt
  
  val bExpr = BinOp("*",Number(5),Number(2))
  
  val BinOp(op,Number(n),right) = bExpr
  
  println(n)
  
  
  //case sequence as partial functions
  val withDefault: Option[Int] => Int = {
    case Some(x) => x
    case None => 0
  } 
  
  println(withDefault(Some(10)))
  println(withDefault(None))

  // Patterns in 'for' expression
  for ( (country,city) <-  capitals)
    println("Capital of "+country +" is "+city)
  
  val fruits = List(Some("Apple"),None,Some("Orange"))
  for ( Some(fruit) <- fruits) println(fruit) //generated values which do not match the patterns are discarded



  

}
