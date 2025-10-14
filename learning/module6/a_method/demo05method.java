package com.learning.module6.a_method;

public class demo05method {
    // 有参有返回值
    public static void main(String[] args) {
        int result = Sum(45,89);
        System.out.println("result="+result);
    }
    public static  int Sum(int num1,int num2){
        int sum=num1+num2;
        return sum;
    }
}
