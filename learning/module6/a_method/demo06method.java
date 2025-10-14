package com.learning.module6.a_method;

public class demo06method {
    public static void main(String[] args) {
    int a = 10;
    int b = 20;
    method(a,b);
    System.out.println("=========================================");

    int result1 = sum(a,b);
        System.out.println("result1="+result1);
    }
    public static int sum(int a,int b){
        int result = a+b;
        return result;
    }

    public static void method(int a, int b){
        System.out.println(a+"mmm"+b);
    }
}
