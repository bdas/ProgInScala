package com.sss.ch7

import io.Source
import java.io.File
import util.control.Breaks

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 30/01/2012
 * Time: 23:19
 * To change this template use File | Settings | File Templates.
 */

object Ch7 extends App {

  // control structure .. SCALA Control Structures can return values
  // no need to have temp variables
  // if, for, try and match

  val x = if (math.random == 1) 1 else 2

  println("value of x:= " + x)


  //Adv of val is that it better supports equational reasoning
  println(if (x == 0) "zero" else "Non zero")


  //while, do while are loops cant return value
  def gcd(x: Long, y: Long): Long = {
    var a = x
    var b = y

    while (a != 0) {
      val temp = a
      a = b % a
      b = temp
    }

    b
  }


  def gcdFun(x: Long, y: Long): Long = if (y == 0) x else gcdFun(y, x % y)


  println("gcd of 3,6 -> " + gcd(3, 6))
  println("gcdFun of 2,3 -> " + gcdFun(2, 3))

  // '{' can be used instead of '('  is useful when using filters with generators
  for {i <- 0 to 2} println("iteration " + i)

  def fileLines(file: File) = Source.fromFile(file).getLines

  //for expression with nested iteration/loops
  def grep(pattern: String) =
    for {
    // generator expression. `file`s type is inferred and is val
      file <- new File(".").listFiles()
      // filter condition
      if file.isFile
      //nested loop
      line <- fileLines(file)
      //mid stream variable bindings as is val
      trimmed = line.trim
      if trimmed.matches(pattern)
    }
      println(file + ":" + trimmed)


  // here return type is Unit
  grep(".*facet.*")


  //producing a new collection. for expression returning value

  def scalaFiles =
    for {
      file <- new File(".").listFiles
      if file.isFile
      if file.getName.endsWith(".scala")
    } yield file

  // f is list
  val f = scalaFiles

  println("list of file:" + f.mkString)

  //throwing exception
  def half(x: Int) =
    if (x % 2 == 0)
      x / 2
    else
    // throw has return type of Nothing
      throw new IllegalArgumentException("cannt be odd")


  // handling exception
  try {
    val l = half(3)
    //catch can be used with pattern matching
  } catch {
    case ex: IllegalArgumentException => //handle
    case ex: RuntimeException => //handle this
  } finally {
    // loan pattern can be used instead of finally block

    //do cleanup
  }

  //scala does not require you to catch checked exception,
  // or declare a throws clause. Although you can annotate with @throws if u prefer

  //yielding value
  //scala's  try-finally behaviour differs from java that it can return value.
  // in java finally block overrules the try block if it returns result or throws error

  def fun(): Int = try {
    return 1
  } finally {
    return 2
  }

  //above returns 2

  def g(): Int = try {
    1
  } finally {
    2
  }

  // above returns 1


  // match expression   is like switch in java   ... string can be used in case, no breaks and no fall through
  // match expression results in value.. unlike switch
  val firstArg = if (args.length > 0) args(0) else ""
  firstArg match {
    case "salt" => println("pepper")
    case "chips" => println("salsa")
    case "eggs" => println("bacon")
    case _ => println("what?")
  }

  val result =
    firstArg match {
      case "salt" => "pepper"
      case "chips" => "salsa"
      case "eggs" => "bacon"
      case _ => "what?"
    }

  println(result)

  // filters can be used in for loop to to skip

  //there is no break and continue in scala;
  //living without break and continue
  // replace every continue by an if
  // every break by a boolean variable

  /* Java code to find scala files not having '-' as first character
    int i = 0;
    boolean foundIt = false;
    while ( i < args.length ){
      if(args[i].startsWith("-")){
        i = i + 1;
        continue;
      }

      if(args[i].endsWith(".scala")){
        foundIt = true;
        break;
      }
      i = i + 1;
    }
   */
  var i = 0
  var foundIt = false
  while (i < args.length && !foundIt) {
    if (!args(i).startsWith("-") && args(i).endsWith(".scala")) {
      foundIt = true
    }
    i += 1
  }

  def searchFrom( index: Int): Int =
    if (index >= args.length) -1
    else if (args(index).startsWith("-")) searchFrom(index + 1)
    else if (args(index).endsWith(".scala")) index
    else searchFrom(index + 1)
  // scala will optimise this recursion to while loop with jump & break; because all recursive calls are in tail-call
  // tail-call optimisation

  //here continue is replaced by recursive call with i+1
   // break is achieved by terminating return

  // However there is method break in Class Breaks in package scala.util.control
  Breaks.breakable{
    while(true){
       Breaks.break
    }
  }



  def makeRow(row: Int) ={
   val rowSeq = for( col <- 1 to 20) yield {
       val prod = (row * col) toString
       val padding  = " " * (4 - prod.length)
       padding + prod
   }
   rowSeq mkString
  }

  def multiTable ={
      val tableSeq =
        for(row <- 1 to 20)
         yield makeRow(row)
    tableSeq mkString "\n"
  }

  print(multiTable)

}
