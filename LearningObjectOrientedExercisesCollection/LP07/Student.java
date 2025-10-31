package com.LearningObjectOrientedExercisesCollection.LP07;

public class Student extends person{
    double score;
    int age =20;
    double height;
    double weight;

    public Student(double score, double weight, double height, int age) {
        this.score = score;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }



    public Student() {
    }

    public void study(){
        System.out.println("学习代码");
    }
    public void eat(){
        System.out.println("吃饭");
    }

    public void a(){
        System.out.println(age);
        System.out.println(this.age);
        System.out.println(super.age);
        eat();
        super.eat();
        study();
        super.study();
    }
}
