package com.Chapter02.demo02

import scala.util.control.Breaks.{break, breakable}

object BreakTest {
  def main(args: Array[String]): Unit = {
    for(i <- 1 to 10){
      print(s"这是外层for i=${i}")

      /**
       * Scala通过  scala.util.control.Breaks.breakable 实现类似于break功能
       * Breaks的核心是通过breakable方法定义一个可跳出的代码块，然后在代码块中使用break方法跳出breakable范围
       */
      breakable{
        for (j <- 1 to 5){
          if(i >= 3){
           break();//跳出内层循环
          }
          println(s"\t内层for: j = $j")
        }
      }
    }
  }

}
