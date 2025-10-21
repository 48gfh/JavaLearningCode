package com.learning.chapter07ObjectOrientedSE.example02;

public class Person {
    //属性 成员变量
    int age;
    String name;
    double height;

    //空构造器
    public Person(){
        System.out.println("这是一个空构造器");
    }

    //有参构造器
    public Person(int age,String name,double height){
        this(age,name);
        this.height=height;
    }
    public Person(int age,String name){
        this(age);
        this.name=name;

    }
    public Person(int age){
        this();
        this.age=age;
    }


    public static void main(String[] args) {
        Person p1 = new Person(19,"lili",67.2);


    }


}
