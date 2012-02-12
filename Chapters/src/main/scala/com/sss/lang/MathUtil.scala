package com.sss.lang

/**
 * Created by IntelliJ IDEA.
 * User: Das
 * Date: 31/01/2012
 * Time: 11:57
 * To change this template use File | Settings | File Templates.
 */

object MathUtil {

  /**
   * Gets the Greatest Common Denominator of <code>a</code> and <code>b</code>
   */
  def findGcd(a: Int, b: Int): Int =
    if (b == 0) a else findGcd(b, a % b)

}