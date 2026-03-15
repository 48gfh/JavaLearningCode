package com.Chapter02.demo02

/**
 * if语句用于执行条件判断、支持单分支、多分支以及作为表达式返回值给变量
 */
object IFTest {
  def main(args: Array[String]): Unit = {
    //if单分支
    val x = 10;
    if (x > 5) {
      println("x is greater than 5")
    }

    //多分支if-else if-else
    val y =10;
    if (y > 10) {
      "y is greater than 10"
    }else if(y==10) {
      "y equals 10"
    }else{
      "y is less than 10"
    }

    //if 作为表达式
    val z =10;
    val result= if (z>5)"greater" else  "less or equal"
    println(result)

  }
}
