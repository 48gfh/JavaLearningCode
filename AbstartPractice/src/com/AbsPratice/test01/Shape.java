package com.AbsPratice.test01;
//抽象类与抽象方法学习示例  图形类
public abstract class Shape {
    private String color;

    //抽象方法计算面积
    public abstract double calArea();
    //抽象方法计算周长
    public abstract double calPerimeter();

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void display(){
        System.out.println("这是一个"+color+"图形");
    }
}
