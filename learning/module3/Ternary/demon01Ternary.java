package com.learning.module3.Ternary;

public class demon01Ternary {
    public static void main(String[] args) {
        // 判断小明的分数是否合格
        int score =62;
        String result01 = score>=60?"及格":"不及格";
        System.out.println("小明的成绩判断为："+result01);

        //有三个老人年纪人别为70  80 60 求出这三个老人的基本信息
        int age1 = 70;
        int age2 = 80;
        int age3 = 90;
        int temple = age1>age3?age1:age3;
        int MaxAge = temple>age2?temple:age2;
        System.out.println("三个老人中年纪最大的为 "+MaxAge);

        //连个老人的年纪分别为70 60 求这两个老人的最高年纪
        int Oldage1 = 70;
        int Oldage2 = 60;
        int MaxOldage  = Oldage1>Oldage2?Oldage1:Oldage2;
        System.out.println("两个老人中年纪最大的是 "+MaxOldage);
    }
}
