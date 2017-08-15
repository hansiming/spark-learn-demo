package com.cszjo.scala

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by hansiming on 2017/8/14.
  */
class CreateRDD {

  //在Scala中class,object和trait的区别
  //class:class只能被实例化才能访问类中变量,无static关键字
  //object:object中的变量都是使用static修饰的,都是单例的,所以main方法要写在object中
  //trait:可以通过特征（trait）实现多重继承，不过与java不同的是，它可以定义自己的属性和实现方法体

  def createRddFromExternalFile(appName: String, textFilePath: String) = {

    val sc = new SparkContext(new SparkConf().setAppName(appName))
    sc.textFile(textFilePath)
  }

  def createRddByExistDataSet(appName: String) = {

    val sc = new SparkContext(new SparkConf().setAppName(appName))
    sc.parallelize(List("tank", "tanks"))
  }
}
