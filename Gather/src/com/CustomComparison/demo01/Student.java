package com.CustomComparison.demo01;

public class Student implements Comparable<Student>{
    private int age;
    private double height;
    private String name;

    @Override
    public int compareTo(Student o) {
        /**
         * 依据年龄对比连个对象
         * return this.getAge()-o.getAge();
         * */
        /**
         * 依据身高对比两个对象
         * */
        return ((Double)(this.getHeight())).compareTo((Double)(o.getHeight()));

    }

    public Student() {
    }

    public Student(int age, double height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", height=" + height +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
