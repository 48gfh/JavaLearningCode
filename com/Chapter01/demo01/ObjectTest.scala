package com.Chapter01.demo01

import com.Chapter01.demo01
import com.Chapter01.demo01.ObjectTest.{age, name}

/**
 * Scala中Object是单列对象，通过object关键字定义，用原图存放静态字段和方法
 */
object ObjectTest {
  println("this is Object");
  val name = "lisi";
  val age = 23;

  def  staticMethod(): Unit = {
    println("this is a statsic method")
  }

  def main(args: Array[String]): Unit = {
  //创建 class 实列
  val cls = new TestClass();
    cls.showClasInfo;
  ObjectTest1("ZhangSan");
    ObjectTest1("LiSi",23);
  }
}

/**
 * 当创建一个object时，如果想传入参数，那么会自动寻找object中的相应参数个数的apply方法。
 */
object ObjectTest1 {
  def apply(name :String)={
    println(s"name is $name")
  }
  def apply(name :String,age :Int)={
    println(s"name is $name, age is $age")
  }
}

class TestClass() {
  println("this is Class");
  def showClasInfo={
    //调用Object 中静态变量
    println(s"name is=$name,age is=$age")

    //调用Object中静态方法
    ObjectTest.staticMethod()
  }
}





