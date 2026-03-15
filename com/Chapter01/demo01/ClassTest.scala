package com.Chapter01.demo01

/**
 * Scala中的类是用于描述对象结构和行为的模板，可以包含字段（变量）、方法以及构造器
 */

object ClassTest {
  def main(args: Array[String]): Unit = {
    //实列化对象
    val person1 = new Person("ZhangSan", 28)
    person1.age=39;//修改可变字段
    person1.showInfo();
    person1.showScore(122);

    val person2 = new Person("ls",34,'d');
    person2.showInfo();
    person2.showScore(300)


  }
}
class Person(Xname: String,XAge: Int){
  //定义字段，通过主构造器参数赋值
  val name = Xname; //常量字段，值不可变
  var age = XAge; //变量字段，值可变
  var gender: Char = 'm'; //可变字段，提供默认值
  var a: Int=_ ; //a的默认值是0
  var b: String=_;//b的默认值为null



  //辅助构造器，必须在第一行调用主构造器
  def this(Xname: String,XAge: Int,ygender: Char) = {

    this(Xname,XAge) //调用主构造器
    this.gender=ygender //设置额外字节
  }

  //定义无参数方法
  def  showInfo(): Unit = {
    println(s"name=$name, age=$age,gender=$gender")
  }
  //定义带参数方法
  def showScore(score: Double)={
    println(s"name=$name,age=$age,score=$score")
  }
  println("person class")
}




