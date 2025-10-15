package com.learning.module6.c_overload;

public class demo01overload {
    public static void main(String[] args) {
        sum(10,20);
        sum(10,20,30);
        sum(10,20,30,40);



    }
    //两个整数相加
    public static void sum(int a,int b){
        System.out.println(a+b);
    }

    //三个整数相加
    public static void sum(int a,int b,int c){
        System.out.println(a+b+c);
    }

    //四个整数相加
    public static void sum(int a,int b,int c,int d){
        System.out.println(a+b+c+d);
    }

    public static void sum(double a,int b){
        System.out.println(a+b);
    }
}
