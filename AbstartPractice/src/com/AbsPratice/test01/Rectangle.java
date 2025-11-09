package com.AbsPratice.test01;

public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(String color) {
        super(color);
    }


    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calArea() {
        return width * height;
    }

    @Override
    public double calPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("矩形 - 宽: " + width + ", 高: " + height);
    }
}
