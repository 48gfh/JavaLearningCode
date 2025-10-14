package com.learning.module4;


import java.util.Random;
import java.util.Scanner;

public class demo04IF {
    public static void main(String[] args) {
        //编写猜数字小游戏
        Random rand = new Random();
        int RandomNum = rand.nextInt(100)+1;
        //System.out.println(RandomNum);

        for (int i = 0;true; i++) {
            Scanner sc1 = new Scanner(System.in);
            int data = sc1.nextInt();
            if (data == RandomNum) {
                System.out.println("正确");
                System.out.println("你猜的次数为："+i);
                break;
            } else if (data > RandomNum) {
                System.out.println("大");

            }else{
                System.out.println("小");
            }


        }




      /*  Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int data = sc.nextInt();
        if(data%2==0) {
            System.out.println("这是一个偶数"+data);
        }else{
            System.out.println("这是一个奇数"+data);
        }*/

    }
}
