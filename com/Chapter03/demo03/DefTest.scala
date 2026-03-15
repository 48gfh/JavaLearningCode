package com.Chapter03.demo03

/**
 * Scala中方法使用def定义在类或者对象中的代码块
 */
object DefTest {
  def main(args: Array[String]): Unit = {
    println(DefTest.max(56, 67))

  }
  def max(num1 :Int,num3:Int): Int = {
    if ((num1 > num3)) {
      return num1  //如果使用return 必须指定方法返回值
    }else {
      return num3
    }
  }
  //简化编写如下
  def max1(num1:Int,num2:Int):Int=if(num1>num2) num1 else num2;

  println(max1(34, 56))

  //方法名与方法体之间的等号去掉，方法中无论返回什么值都会丢弃，返回Unit
  def max2(num1:Int,num2: Int){
    if (num1 > num2) {
      num1
    }else{
      num2
    }
  }
  println(max2(90, 78));


}
