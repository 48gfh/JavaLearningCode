package com.learning.chapter6_method;

import java.util.Scanner;

public class demo04 {
    //编写一个方法，接收一个整数参数n，输出n 个HelloWorld。
    public static void main(String[] args) {
        System.out.println("请输入参数");
        Scanner sc = new Scanner(System.in);
        int data1 = sc.nextInt();
        outPut(data1);

    }

    public static void outPut(int data1) {
        for (int i = 0; i < data1; i++) {
            System.out.println("Hello Word");
        }
    }
}
