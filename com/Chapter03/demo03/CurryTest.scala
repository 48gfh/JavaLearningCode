package com.Chapter03.demo03

/**
 * 柯里化（Currying）是指将一个接受多个参数的函数转换为一系列接受单一参数/参数组的函数调用的过程。在 Scala 中，一个普通函数通常会接受多个参数
 */
object CurryTest {
  def fun(a:Int,b:Int)(c:String,d:Int)={
    val i: Int = a + b + d
    c+"-"+i
  }
  def main(args: Array[String]): Unit = {
    println(fun(1,2)("a",3))

  }

}
