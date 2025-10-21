package com.learning.chapter07ObjectOrientedSE.ProgrameExercise02;

public class TestVehicle {
    /**
    * 类的成员变量 请定义一个交通工具(Vehicle)的类其中有: 属性速度(speed)体积(size)等等
     * 方法移动(move())设置速度(setSpeed(int speed))加速speedUp(),减速speedDown()等等.
     * 最后在测试类Vehicle中的main()中实例化一个交通工具对象并通过方法给它初始化speed,size的值并且通过打印出来。
     * 另外调用加速减速的方法对速度进行改变。
    * */

    public static void main(String[] args) {
        //实列化一个小车
        Vehicle  car=new Vehicle();
        //启动车辆
        car.Move();
        //显示车子目前速度
        car.setSpeed(100);
        //车子提速
        car.speedUP();
        //车子减速
        car.speedDown();


    }
}
