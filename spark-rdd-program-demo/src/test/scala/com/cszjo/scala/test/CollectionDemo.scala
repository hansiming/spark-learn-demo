package com.cszjo.scala.test

import org.junit.Test
import scala.collection.mutable.Map

/**
  * Created by hansiming on 2017/8/15.
  */
class CollectionDemo {

  @Test def mapTest(): Unit = {

    val myMap = Map("john" -> 21, "stephen" -> 22,"lucy" -> 20)

    for (e <- myMap)
      println(e)

    myMap.foreach(e => {
      println(e._1 + " : " + e._2)
    })

    println(show(myMap.get("john1")))
  }

  def show(x : Option[Int]) = x match {
    case Some(s) => s
    case None => "???"
  }
}
