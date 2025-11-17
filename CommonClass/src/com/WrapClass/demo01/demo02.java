package com.WrapClass.demo01;

public class demo02 {
    public static void main(String[] args) {
        // 方式1 valueof() 方法  创建包装类
        Integer data2 =Integer.valueOf(10);
        Integer data3 =Integer.valueOf("100");
        System.out.println(data2);
        System.out.println(data3);

        //方法2 自动装箱和拆箱
        //自动装箱： 基本类型 -> 包装类
        Integer data4 =100;  //等价于Integer.valueof(100)
        //自动拆箱： 包装类 -> 基本类
        int data5 =data4; //也可以使用data4.valueof()
        int data6=data3.intValue();

        //方法3 常用方法
        Integer num=100;
        //转为基本类型
        int intValue = num.intValue();
        double doubleValue= num.doubleValue();

        //类型转换
        String str="123";
        int number =Integer.parseInt(str);//字符串 -> int
        Integer integer =Integer.valueOf(str); //字符串 -> Integer
        String numStr =num.toString();  //Integer -> 字符串

        //比较
        Integer x= 100,y=200;
        int result=x.compareTo(y);

        //常量值
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);


    }
}
