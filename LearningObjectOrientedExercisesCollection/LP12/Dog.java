package com.LearningObjectOrientedExercisesCollection.LP12;

public class Dog extends Animal{
    public void test(){
        this.special="犬"; //调用父类的属性
        this.protectedMethod(); //调用父类的protected方法

    }

    public static void main(String[] args) {
        new Dog().test();
    }
}
