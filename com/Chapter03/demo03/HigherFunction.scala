package com.Chapter03.demo03

/**
 * Scala的高阶函数包括一下几种情况
 * 1、方法的参数是函数
 * 2、方法的返回类型是函数
 * 3、方法的参数和返回类型均是函数
 * 高阶函数就是通过将函数作为参数或返回值，增强了代码的灵活性和可复用性
 */
object HigherFunction {
  //方法的参数是函数
  def highfun1(f:(Int,Int)=>Int,a :Int):Int={
    f(a,100)
  }
  def add(v1: Int,v2:Int): Int = {
    v1+v2
  }
  //方法的返回类型是函数
  def highfun2(num1:Int,num2:Int):(Int,Int) =>Int = {
    def f2(v1:Int,v2:Int): Int = {
      v1+v2+num1+num2
    }
    f2

  }

  //方法的参数和返回类型均是函数
  def highfun3(f: (Int,Int)=>Int):(Int,Int) => Int={
    f
  }




  def main(args: Array[String]): Unit = {
    println("方法是参数的函数调用"+highfun1(add, 1))
    println("方法的返回类型均是函数" + highfun2(1, 2)(3, 4))
    println("方法参数和返回类型都是函数"+highfun3((a, b) => a + b)(200, 330))
    //简化写法
    println(highfun3(_ + _)(200, 200))
  }

}
