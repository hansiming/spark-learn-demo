package com.cszjo.scala

/**
  * Created by hansiming on 2017/8/14.
  */
class Student{
  var age=20     //底层编译器会自动为私有的age添加get和set的公有方法,可以理解为伪public类型
  private[this] var gender="male" //private[this] 只有该类的this可以使用
  private var name="clow" //声明了private,底层编译器会自动为私有的name添加get和set的私有方法
  //但是可以自己定义属性方法
  def getName=this.name
  def setName(value:String){this.name=value}
}
