package com.Chapter03.demo03

/**
 * 递归方法是指方法的自身调用，通常用于处理重复性问题
 */
object recurisveFun {
  def main(args: Array[String]): Unit = {
    recurisveFun;
    paramFun();
    paramFun(45,90);
    paramFun(b = 78);

  }
  /**
   * 递归方法
   *  计算5的阶乘
   */
  def recursiveFun(num :Int):Int = {
    if(num ==1)
      num
    else
      num * recursiveFun(num-1)
  }

  print(recursiveFun(5)) //结果120

  /**
   *参数默认值 Scala支持为方法参数设置默认值，当调用的时候省略某个参数时，该参数就会使用默认值
   */
  def paramFun(a :Int=10,b:Int=20)= {
    println(a + b)
  }

  /**
   * 匿名函数是一种没有名称的函数，可以赋值给一个变量，或者作为参数传递给其他函数使用
   * 匿名函数既可以有参也可以无参
   */
  //无参匿名函数
  val fun1= () =>{
    println("hello word")
  }

  //有参匿名函数
  val fun2:(Int,Int)=>Unit=(a:Int,b: Int)=>{
  println(a*b)
  }
  //返回有参匿名函数
  val fun3: (Int,Int)=>Int=(nu1 :Int,nu2: Int)=>{
    nu1+nu2
  }
}
