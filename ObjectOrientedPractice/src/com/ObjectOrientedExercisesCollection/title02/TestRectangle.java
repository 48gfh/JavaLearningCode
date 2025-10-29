package com.ObjectOrientedExercisesCollection.title02;

import java.util.Scanner;
/**
 * 定义一个矩形类（Rectangle），包含长（length）和宽（width）属性，
 * 并实现计算面积和周长的方法
 * */
public class TestRectangle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("分别输入长宽");
        double p1 = sc.nextDouble();
        double p2 = sc.nextInt();
        Rectangle re= new Rectangle(p1,p2);


    }
}
