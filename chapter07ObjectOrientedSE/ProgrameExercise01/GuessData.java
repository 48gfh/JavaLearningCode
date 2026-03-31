package com.learning.chapter07ObjectOrientedSE.ProgrameExercise01;

import java.util.Scanner;

public class GuessData {
    /**
     * 类的成员变量 猜数字游戏一个类A有一个成员变量v有一个初值100。
     * 定义一个类对A类的成员变量v进行猜。如果大了则提示大了小了则提示小了。等于则提示猜测成功。*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入猜测的数字");
        int inputData = sc.nextInt();
        //调用类
        Adata data = new Adata();
        int vdata=data.v;
        //System.out.println(vdata);
        while (true){
            if (inputData>vdata){
                System.out.println("你猜测的数字大了");
                break;
            } else if (inputData == vdata) {
                System.out.println("恭喜你猜中");
                break;
            }else {
                System.out.println("你猜的数字小了");
                break;
            }
        }

    }
}
