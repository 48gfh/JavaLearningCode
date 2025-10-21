package com.learning.chapter07ObjectOrientedSE.ProgrameExercise;

public class TestStudent {
    public static void main(String[] args) {
        //使用对象调用
        Student s1 =new Student();
        s1.setAge(19);
        s1.setName("lili");
        s1.setSex("女");
        //打印学生信息
        System.out.println(s1.getAge());
        System.out.println(s1.getName());
        System.out.println(s1.getSex());

        //使用构造器调用
        Student s2 = new Student(34,"zhangsan","男");
        System.out.println("性别"+s2.getSex()+"姓名"+s2.getName()+"年龄"+s2.getAge());




    }
}
