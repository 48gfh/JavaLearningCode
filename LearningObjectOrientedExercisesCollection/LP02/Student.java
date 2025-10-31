package com.LearningObjectOrientedExercisesCollection.LP02;
/**
 * static 修饰属性
 * */
public class Student {
    //属性
    String name;
    int age;
    static String school;

    public static void main(String[] args) {
        //可以用于定义对象中固定值
        Student.school="工业经济";
        //创建学生对象
        Student s1 = new Student();
        s1.name="zhangsan";
        s1.age=23;
        System.out.println("姓名"+s1.name+"年龄"+s1.age+"学校"+school);

        Student s2=new Student();
        s2.name="lili";
        s2.age=20;
        System.out.println("姓名"+s2.name+"年龄"+s2.age+"学校"+school);


    }
}
