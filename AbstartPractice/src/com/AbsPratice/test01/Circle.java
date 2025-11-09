package com.AbsPratice.test01;

public class Circle extends Shape{
   //圆的半径
    private double radius;

    public Circle(String color) {
        super(color);
    }

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calPerimeter() {
        return 2 * Math.PI * radius;
    }

    public void display(){
        super.display();
        System.out.println("圆形 - 半径: " + radius);
    }
}
