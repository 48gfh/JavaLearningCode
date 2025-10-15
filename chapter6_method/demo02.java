package com.learning.chapter6_method;

import java.util.Scanner;

public class demo02 {
    // 编写一个方法，接收一个整数，输出这个整数的所有因子
    public static void main(String[] args) {
        System.out.println("请输入一个整数，自动计算因子");
        Scanner sc = new Scanner(System.in);
        int data1 =sc.nextInt();
        factor1(data1);
    }

    //使用穷举法计算因子
    public static void factor1(int num1){
        for (int i = 1; i < num1; i++) {
            if(num1%i==0){
                System.out.println(i+"是"+num1+ "的因子");
            }
        }
    }


}
