package com.LearningObjectOrientedExercisesCollection.LP06;

public class Student extends Person{
    public void Study(){
        System.out.println("敲代码学习");
    }
    /**
     * override 在不同类中子类对父类提供的代码不满意，可以对父类的方法进行重写
     * */
    @Override
    public void eat() {
        System.out.println("吃米饭");
    }

    @Override
    public void sleep() {
        System.out.println("睡在沙发上");
    }
}
