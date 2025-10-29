package com.ObjectOrientedExercisesCollection.title03;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
/**
 *定义一个三角形类（Triangle），
 * 包含三个边长（a, b, c）属性，并实现一个判断是否为等边三角形的方法。
 * */
public class equilateralTriangle {
    Scanner sc = new Scanner(System.in);
    public void et(){
        System.out.println("分别输入三角形的三条边");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        Triangle t1 = new Triangle(a,b,c);
        if (t1.getA()== t1.getB()||t1.getB()==t1.getC()){
            System.out.println("是等边三角形");
        }else {
            System.out.println("不是等边三角形");
        }

    }


}
