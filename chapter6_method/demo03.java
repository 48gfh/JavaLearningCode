package com.learning.chapter6_method;

import java.util.Scanner;

public class demo03 {
    //编写一个方法，接收一个整数n，输出1+2+3+…+n 的和
    public static void main(String[] args) {
        accumulation();
    }
    public static void accumulation(){
        System.out.println("输入一个整数，将自动计算累加和");
        Scanner sc = new Scanner(System.in);
        int data1 = sc.nextInt();
        int sum=0 ;
        for (int i = 0; i <data1 ; i++) {
            sum+=data1;
        }
        System.out.println(data1+"累加计算结果为"+sum);

    }
}
