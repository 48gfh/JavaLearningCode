package com.learning.chapter6_method;

import java.util.Scanner;

public class demo06 {
    //验证哥德巴赫猜想 现代表述：任一大于2的偶数都可写成两个质数之和
    public static void main(String[] args) {
        GoldbachConjecture();
    }

    public static void GoldbachConjecture() {
        System.out.println("请输入一个大于2");
        Scanner sc= new Scanner(System.in);
        int data = sc.nextInt();
        if (data>2){
            logic(data);
        }else {
            System.out.println("无效数字请重新输入");
        }

    }

    public static void logic(int data1) {
        // 首先检查是否为偶数
        if (data1 % 2 != 0) {
            System.out.println("请输入偶数");
            return;
        }

        // 寻找两个质数使得它们的和等于目标数
        for (int i = 2; i <= data1 / 2; i++) {
            if (isPrime(i) && isPrime(data1 - i)) {
                System.out.println(data1 + " = " + i + " + " + (data1 - i));
                System.out.println(data1 + " 符合哥德巴赫猜想");
                return;
            }
        }
        System.out.println(data1 + " 不符合哥德巴赫猜想");
    }
    //判断是否为质数
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int k = 2; k <= Math.sqrt(num); k++) {
            if (num % k == 0) return false;
        }
        return true;
    }
}
