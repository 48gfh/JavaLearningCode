package com.Chapter03.demo03


object FunTest {
  def main(args: Array[String]): Unit = {
    fun("zhangsan",45)

    //定义一个方法
    def add(num1:Int,num2:Int): Int=num1+num2;
    //把方法转为函数
    val addFunction1=add _;
    val addFunction2:(Int,Int) => Int=add;

  }
  //定义fun函数 在scala中函数是一段代码块，可以存储在变量中
  val fun = (name:String,age:Int)=>{
    println(s"name is $name,age is $age ") }
}
