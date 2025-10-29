package com.ObjectOrientedExercisesCollection.title03;
/**
 *定义一个三角形类（Triangle），
 * 包含三个边长（a, b, c）属性，并实现一个判断是否为等边三角形的方法。
 * */
public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle() {
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}
