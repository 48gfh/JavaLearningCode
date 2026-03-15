package com.Chapter02.demo02

object StringTest {
  def main(args: Array[String]): Unit = {
    /**  String 不可变字符串
     * String类型继承于Java,并扩展了函数式操作支持。
     * Scala中对String类型字符串进行操作（如替换、转换等）会返回新的字符串，而不会修改原有内容。
     */
    val str="abcd";
    val str1="ABCD";
    //给字符串追加内容，并返回新的对象
    val str2: String =str.+("aacsd");
    println(str2)
    //忽略大小写比较 equalsIgnoreCase
    println(str.equalsIgnoreCase(str1))
    //查找字符或子字符串位置 indexOf
    println(str.indexOf(97)) //ASCII值对应字符 a
    println(str.indexOf('b'))// 'b'的位置
    //大小写转换
    println(str.toUpperCase)
    println(str1.toLowerCase)
    //替换字符或字符串
    println(str.replace('a', 'c'))
    //分割字符串
    val parts =str.split('b')
    println(parts mkString ",")

    /**
     * String Builder 可变字符串
     * StringBuilder允许直接修改字符串内容，无需创建新对象，性能更高，常用于高效处理大规模字符串操作
     */
    val strbuilder = new StringBuilder();
    //追加字符
    strbuilder.append("hello scala");
    //追加单个字符
    strbuilder+='H';
    //追加另一字符串
    strbuilder++="Hadoop"
    //追加数据
    strbuilder.append(1.3);
    strbuilder.append(18f);//f表示单精度浮点
    println(strbuilder)

    /**
     * 字符串比较可以使用equals,==,eq 三种比较方式
     */
    val strE1 = "hello"
    val strE2 = "hello"
    val strE3 = new  String("hello")
    val strE4: String = null

    //equals 值相等 判断内容是否完全相等，但是不能安全处理null
    println(strE1.equals(strE2))
    println(strE1.equals(strE3))
    //println(strE4.equals(strE1)) //无法处理空值

    //== 值相等  对于引用类型来说比较的是地址，对于基本类型来说进行数值比较
    println(strE1 == strE2)
    println(str1 == strE3)
    println(strE1 == strE3)
    println(strE4==strE3)//返回false安全处理null

    //eq 引用推荐
    println(strE1.eq(strE2))//true 表示两个字符串都指向字符串同一池中的同一对象
    println(strE1.eq(strE3))//flase strE3是通过new创建的，不同的应用

    /**
     * 字符串格式化输出
     */
    val name = "zs"
    val age = 18
    val score = 18.469
    //使用s插值器,直接在字符串中嵌入变量或表达式
    println(s"name is $name,\nage is $age,\nscore is $score")
    //使用f插值器，结合占位符来控制格式化输出
    println(f"name is $name%s,\nage is $age%d,\nscore is $score%.2f")
    //使用raw插值器，保留字符串中转义字符
    println(raw"name is $name%s,\nage is $age%d,\nscore is $score%.2f")

    /**
     * Scala中的多行字符串使用 | 分隔内容， 并通过 stripMargin 方法去除前导空格。
     */
    val text=
      s"""
         |hello,$name
         |hadoop  Scala Spark
         |""".stripMargin
    println(text)


  }
}
