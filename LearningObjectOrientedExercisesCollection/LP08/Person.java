package com.LearningObjectOrientedExercisesCollection.LP08;

import javax.swing.plaf.synth.SynthTreeUI;

/**
 * super 调用父类构造器
 * */
public class Person {
    private String name;
    private int age;
    //父类构造器
    private Person(){
        this.name="zhangSan";
        this.age=0;
        System.out.println("Person无参构造器被调用");
    }
    public Person(String name,int age){
        this.name=name;
        this.age=age;
        System.out.println("Person有参构造器被调用");
    }

    //子类
    public static class Student extends Person {

        private String school;

        //子类构造器 调用父类无参构造器
        public Student(){
            //调用父类无参构造器
            super();
            this.school="工业经济";
            System.out.println("Student无参构造器被调用");
        }

        public Student(String name,int age,String school){
            super(name,age);
            this.school=school;
            System.out.println("Student有参构造器被调用");
        }
    }
}
