package com.ObjectOrientedExercisesCollection.title02;
/**
 * 定义一个矩形类（Rectangle），包含长（length）和宽（width）属性，
 * 并实现计算面积和周长的方法
 * */
public class Rectangle {
    private double length;
    private double windth;

    public Rectangle() {
    }

    public Rectangle(double length, double windth) {
        this.length = length;
        this.windth = windth;
        double are=calculate(this.length,this.windth);
        System.out.println("面积是"+are);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWindth() {
        return windth;
    }

    public void setWindth(double windth) {
        this.windth = windth;
    }
    public double calculate(double parameter,double parameter1){
        double are =parameter*parameter1;
        return are;

    }

}
