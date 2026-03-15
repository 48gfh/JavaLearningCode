package com.Chapter01.demo01

/**
 * 当一个类和另一个对象同名且定义在同一个文件中，
 * 这个类称为半生类而这个对象称为伴生对象。两者属于伴生关系。可以互相访问对象的私有成员
 */

class Student(xname:String,xage :Int) {
  private val name=xname;
  val age =xage

  def sayName()={
    //类中获取Object中私有变量
    s"Object name is ${Student.yname}"
  }
}

object Student {
  val yname="ZhangSan";
  def main(args: Array[String]): Unit = {
    val student = new Student("LiSi", 23)
   //获取类中有变量
    println(student.name)
    println(student.sayName())


  }
}





