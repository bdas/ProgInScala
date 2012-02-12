package com.sss.ch15

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 07/02/12
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 */

sealed abstract class Expr

case class Var(name: String) extends Expr

case class Number(num: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr


