package com.learning.chapter6_method;

import java.util.Random;
import java.util.Scanner;

public class demo01 {
    //编写一个方法，接收两个整数作为参数，返回这两个整数的和。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个整数");
        int data1 = sc.nextInt();
        System.out.println("请输入第二个整数");
        int data2 = sc.nextInt();
        System.out.println("整数和为"+add(data1,data2));

    }

    public static int add(int num1,int num2){
        int sum = num1+num2;
        return sum;
    }
}
