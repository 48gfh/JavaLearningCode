package com.ObjectOrientedExercisesCollection.title01;
/**
 * 定义一个学生类（Student），包含姓名（name）和年龄（age）属性，并实现一个打印学生信息的方法。
 */


public class Student {
    String name;
    int age;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
        this.studentShow();
    }

    public Student() {
    }
    public void studentShow(){
        System.out.println("姓名"+this.name+"\t"+"年龄"+this.age);
    }

}
