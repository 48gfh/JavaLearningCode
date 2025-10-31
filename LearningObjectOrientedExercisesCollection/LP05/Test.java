package com.LearningObjectOrientedExercisesCollection.LP05;

public class Test {

    public static void main(String[] args) {
        Student s =new Student();
        s.setSno(100);
        s.setAge(10);
        s.setName("lili");
        s.setHeight(34);

        System.out.println("学生姓名"+s.getName()+"学生年纪"+s.getAge());

        //访问方法
        s.study();
        s.eat();
        s.sleep();
    }
}
