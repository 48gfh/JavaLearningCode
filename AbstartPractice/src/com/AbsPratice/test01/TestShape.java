package com.AbsPratice.test01;

public class TestShape {
    public static void main(String[] args) {
        Shape t1 =new Circle("绿色",5.0);
        Shape t2 =new Rectangle("红色",4.0,6.0);

        //测试方法
        t1.display();
        System.out.println("圆的颜色是："+t1.getColor()+"圆的面积是"+t1.calArea()+"圆的周长是"+t1.calPerimeter());
        t2.display();
        System.out.println("矩形的颜色是："+t2.getColor()+"矩形的面积是"+t2.calArea()+"矩形的周长是"+t2.calPerimeter());

        // 多态演示
        System.out.println("=== 多态演示 ===");
        Shape[] shapes = {
                new Circle("绿色", 3.0),
                new Rectangle("黄色", 2.0, 3.0),
                new Circle("紫色", 7.0)
        };

        for (Shape shape : shapes) {
            shape.display();
            System.out.printf("面积: %.2f, 周长: %.2f\n",
                    shape.calArea(), shape.calPerimeter());
            System.out.println("---");
        }
    }
}
