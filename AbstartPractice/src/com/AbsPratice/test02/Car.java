package com.AbsPratice.test02;

public class Car extends Vehicle{
    private String doors;

    public Car(String brand, int year, String doors) {
        super(brand, year);
        this.doors = doors;
    }

    @Override
    public void start() {
        System.out.println("车在高速公路上行使");

    }

    @Override
    public void stop() {
        System.out.println("车在高速公路服务区停车");
    }

    @Override
    public void display() {
        System.out.println("车厂"+getBrand()+"车牌"+getDoors()+"出厂日期"+getYear());
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }
}
