package com.ObjectOrientedExercisesCollection.title01;

public class TestStudent {
    public static void main(String[] args) {
        /**
         * 定义一个学生类（Student），包含姓名（name）和年龄（age）属性，并实现一个打印学生信息的方法。
         */
        // 方法一
       /* Student Student01=new Student();
        Student01.name="zhangsan";
        Student01.age=18;
        System.out.println("学员的信息为"+Student01.name+"年龄"+Student01.age);*/
        Student s1 =new Student(18,"ZhangSan");

    }
}
