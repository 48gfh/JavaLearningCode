package com.Chapter03.demo03

object MethTest {
  def main(args: Array[String]): Unit = {
    printStrings("a", "b", "c", "d")
    println(fun(2))
  }

  def  printStrings(elements: String*):Unit={
    //遍历参数并打印
    //方法一 使用for循环
   /* for (elem <- elements) {
      println(elem)
    }*/
    //方法二 使用foreach 搭配匿名函数
    elements.foreach((s: String)=>println(s))
    //简化写法1 胜利类型差异
    elements.foreach(s=> println(s))
    //简化写法2 使用占位符
    elements.foreach(println(_))
    //简化写法3 进一步简化直接传入方法引用
    elements.foreach(println)
  }

  /**
   *嵌套方法 指在一个方法内部定义另一个方法
   */
  def fun(a: Int)= {
    val i=a+5;
    def fun3(num:Int): Int = {
      if (num == 2)  num else 5*num
    }
    fun3(i)
  }

  /**
   * 偏应用表达式 当方法固定某些参数后，生成一个新的函数。
   */
  def logFun(level :String,message :String)={
    println(s"[$level]: $message")
  }
  //正常调用方法
  logFun("INFO","message1")
  logFun("INFO","message2")
  logFun("INFO","message3")
  //使用偏应用表达式：调用log方法，传入固定参数，变化参数使用 _表示，赋值给新的函数
  val infoLog = logFun("INFO",_:String)
  infoLog("message1")
  infoLog("message2")
}
