package com.LearningObjectOrientedExercisesCollection.LP05;

public class Student extends Person{
    //子类student继承父类Person
    private int sno; //学号

    //方法
    public void study(){
        System.out.println("学生可以学习");
    }


    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }
}
