package com.cszjo.scala.test

import org.junit.Test

/**
  * Created by hansiming on 2017/8/14.
  */
class TestDemo1 {

  @Test def testClassAndObject(): Unit = {
    val intArr = new Array[Int](3)

    intArr(0) = 1
    intArr(1) = 2
    intArr(2) = 3


//    for (i <- 0 to intArr.length - 1)
//      println(intArr(i))
//
//    for (i <- intArr)
//      println(i)
//
//    for (i <- 0 until (intArr.length, 2))
//      println(intArr(i))
//
//    for (i <- (0 until intArr.length).reverse)
//      println(intArr(i))

    val nums = 1::2::3::4::Nil
    for (i <- nums)
      println(i)
  }
}
