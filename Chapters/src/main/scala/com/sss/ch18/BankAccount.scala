package com.sss.ch18

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 08/02/12
 * Time: 14:23
 * To change this template use File | Settings | File Templates.
 */

class BankAccount {

  private var bal: Int = 0

  def balance: Int = bal

  def deposit(amount: Int) {
    require(amount > 0)
    bal += amount
  }

  def withdraw(amount: Int): Boolean = {
    require(amount > 0)
    if (amount > bal) false
    else {
      bal -= amount
      true
    }
  }

}
