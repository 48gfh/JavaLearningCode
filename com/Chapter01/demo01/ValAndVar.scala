package com.Chapter01.demo01

import scala.collection.mutable.ListBuffer

object ValAndVar {
  def main(args: Array[String]): Unit = {
   //声明变量
    var id=10;
    id =100; //可以重新赋值
    println(id);

    var age: Int=200; //Int类型也可以不屑，scala可以自己推断
    age =200;
    println(s"age=${age}")

    //声明常量
    val name="ZhangSan";
    //name="LiSi"; val 定义的变量为常量不可重新赋值
    println(s"name=${name}")

   //List 引用不可变，但是其内容可变，可以修改内部状态
   val list: ListBuffer[Int] = ListBuffer(1, 2, 3, 4, 5);
   list.addOne(90);
   println(list)




  }

}
