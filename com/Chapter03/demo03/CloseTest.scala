package com.Chapter03.demo03

/**
 * 是 Scala 中的重要概念，
 * 指一个函数能够捕获并使用未在其内部声明的外部变量。闭包的核心是将函数和其引用的外部变量“打包”在一起，使得函数在任意地方执行时都能访问这些变量。用通俗的话说，闭包就是一个“带着外部变量的函数”
 */
object CloseTest {
  //定义一个外部变量
  var number =10;
  number=20;
  //定义一个方法，捕获外部变量 函数addToNumber就是闭包，捕获了外部变量 number
  def addToNumber(x :Int): Int = {
    x+number
  }

  def main(args: Array[String]): Unit = {
    //调用函数
    println(addToNumber(5))

  }
}
