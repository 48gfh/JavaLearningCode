package com.learning.chapter07ObjectOrientedSE.ProgrameExercise;

public class Student {
    private int age;
    private String name;
    private String sex;

    public Student(){

    }
    public Student(int age, String name, String sex) {
        this.setAge(age);
        this.setName(name);
        this.setSex(sex);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 18){
            this.age = age;
        }else {
            System.out.println("输入不符合规范");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() > 0){
            this.name = name;
        }else {
            System.out.println("无效输入");
        }

    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        if(sex == "女"){
            this.sex = sex;
        }else {
            this.sex="男";
        }

    }



}
