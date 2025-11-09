package com.AbsPratice.test02;

public class TestVehicle {
    public static void main(String[] args) {
         Vehicle c1 =new Car("AO奥迪",2024,"皖F676");
         Vehicle b1 =new Bicycle("凤凰",2025);
        System.out.println("基本信息展示");
         c1.display();
         b1.display();
        System.out.println("运行信息");
        c1.start();
        c1.stop();
        b1.start();
        b1.stop();
    }
}
