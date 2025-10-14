package com.learning.module4;

import java.util.Scanner;

public class demo03Switch {
    public static void main(String[] args) {
       /* Scanner sc =new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int data = sc.nextInt();
        switch (data){
            case 1:
                System.out.println("鹅鹅鹅");
            case 2:
                System.out.println("曲项向天歌");
            case 3:
                System.out.println("白毛浮绿水");
            case 4:
                System.out.println("红掌拨清波");
            break;
            default:
                System.out.println("无效输入");
                break;*/
        Scanner sc  = new Scanner(System.in);
        System.out.println("请输入对应的月份");
        int Mounth = sc.nextInt();
        switch(Mounth){
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            default:
                System.out.println("无效月份重新输入");

        }
        }
    }

