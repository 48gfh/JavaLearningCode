package com.learning.chapter6_method;

import java.util.Scanner;

public class demo05 {
    //编写一个方法，接收一个整数，输出这个整数是几位数
    public static void main(String[] args) {
        count();

    }
    public static void count(){
        System.out.println("请输入一个整数");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        int originalData=data;
        int count=0;
        //处理负数情况
        if(data < 0 ){
            data = -data;
            count++;
        }
        //处理0的特殊情况
        if(originalData==0){
            count=1;
        }

        while (data > 0){
            data=data/10;
            count++;
        }
        System.out.println(originalData+"是一个"+count+"位的小数");
    }
}
