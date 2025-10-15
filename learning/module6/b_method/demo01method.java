package com.learning.module6.b_method;

import java.util.Scanner;

public class demo01method {

    public static void main(String[] args) {
        method(3);
    }
    public static void method(int a) {
        for (int i = 0; i < 3; i++) {
            System.out.println("我是一个有经验的数据开发工程师");
        }
    }






/*
    //定义一个方法计算100以内整数累加
    public static void main(String[] args) {
        int result =add();
        System.out.println("100以内的累加结果为"+result);

    }

    public static int add(){
        int Sum=0;
        for (int i = 0; i < 100; i++) {
            Sum=Sum+i;
        }
        return Sum;
    }

*/









   /* //从键盘录入一个整数,将整数传递到另一个方法中，如果遇到偶数，方法就返回偶数，否则返回整数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int data1 = sc.nextInt();
        String  result =compare(data1);
        System.out.println("该数字"+result);


    }
    public static String compare(int a){
        if(a%2==0){
            return "是偶数";
        }else {
            return "不是偶数";
        }*/

    }

