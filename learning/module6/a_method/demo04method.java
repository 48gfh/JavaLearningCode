package com.learning.module6.a_method;

public class demo04method {
    public static void main(String[] args) {
        //打印调用，了解即可，不推荐使用
        System.out.println("Sum="+sum());

        //赋值调用，推荐使用
        int result = sum();
        System.out.println("result="+result);
    }
    public static  int sum(){
        int a = 10;
        int b = 20;
        int Sum = a+b;
        return  Sum;
    }
}
