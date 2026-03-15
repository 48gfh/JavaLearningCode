package com.Chapter02.demo02

object WhileTest {
  def main(args: Array[String]): Unit = {
    var index = 2;
    while(index<100){
      println(index)
    }
    //do...while 循环
    do {
      index+=1
    }while(index<20)
  }
}
