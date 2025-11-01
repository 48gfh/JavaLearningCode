package com.LearningObjectOrientedExercisesCollection.LP10;
/**
 * 方法重载示例
 * */
public class Calculator {
    public static void main(String[] args) {

    }

    //方法重载 参数不同
    public  int add(int data1,int data2){
        return data1+data2;
    }
    public int add(int data1,int data2,int data3){
        return data1+data2+data3;
    }

    //方法重载 参数类型不同
    public double add (double data1,double data2){
        return data1+data2;
    }

    //参数顺序不同
    public void printInfo(String name,int age){
        System.out.println("姓名"+name+"年龄"+age);
    }

    public void printInfo(int age,String name){
        System.out.println("年龄"+age+"姓名"+name);
    }

    //返回类型可以重载，但是参数列表必须不同
    public  String add(String a,String b){
        return a+b;
    }

}
