package com.Chapter02.demo02

object ForTest {
  def main(args: Array[String]): Unit = {
    //返回1-5的Range数组,包含5。
    //to 包含结束值
    for (i <- 3 to 5){
      println(i)
    }
    print("========================");
    //返回1-5的Range数组，不包含5
    //until不包含结束值
    for (i <- 1 until 5){
      println(i)
    }
    //to和 until 两者都可以通过by指定步长，可以了省去by
    println((1 to 10).toList)
    println((1 to 10 by 3).toList)
    println((1 to(10, 3)).toList)
    println((1 until 10).toList)
    println((1 until (10,3)).toList)

    //在for循环中添加条件，过滤不符合条件的元素
    for(i <- 1 to 10;if(i%2)==0;if(i==4)){
      println(i)
    }
    //条件可以不加分号
    for(i <- 1 to 30 if(i%2)==0 if(i==4)){
      println(i)
    }

    //嵌套for循环
    for (i <- 1 to 20){
      for (j <- 1 until 20){
        println(s"i number is ${i},j number is ${j}")
      }
    }
    //等价于
    for (i <- 1 to 20;j <- 1 to i){
      println(s"i number is $i, j is number is $j")
    }

    //for表达式可以通过yield返回一个新的集合
   val result= for(i <- 1 to 5) yield i*i*i;
    println(result)
  }
}
