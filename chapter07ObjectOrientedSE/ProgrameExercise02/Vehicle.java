package com.learning.chapter07ObjectOrientedSE.ProgrameExercise02;
/**
 *类的成员变量 请定义一个交通工具(Vehicle)的类其中有: 属性速度(speed)体积(size)等等
 *方法移动(move())设置速度(setSpeed(int speed))加速speedUp(),减速speedDown()等等
 * */
public class Vehicle {
    double speed;
    double size;
    public void Move(){
        System.out.println("moving");
    }
    public void setSpeed(int speed){
        System.out.println("目前小车移动速度"+speed);

    }
    public void speedUP(){
        Vehicle v = new Vehicle();
        v.setSpeed(110);
    }
    public void speedDown(){
        Vehicle v = new Vehicle();
        v.setSpeed(30);

    }


}
