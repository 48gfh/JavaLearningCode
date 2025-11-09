package com.AbsPratice.test02;

public class Bicycle extends Vehicle{


    public Bicycle(String brand, int year) {
        super(brand, year);
    }

    @Override
    public void start() {
        System.out.println("在非机动车道骑车");
    }

    @Override
    public void stop() {
        System.out.println("停车上锁");
    }

    @Override
    public void display() {
        System.out.println("自行车品牌"+getBrand()+"自行车生产年份"+getYear());
    }
}
