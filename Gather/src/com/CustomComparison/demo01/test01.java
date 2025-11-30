package com.CustomComparison.demo01;

public class test01 {
    public static void main(String[] args) {
        Student s1 =new Student(14,78.0,"zhangsan");
        Student s2 =new Student(19,77.0,"lisi");
        System.out.println(s1.compareTo(s2));

    }
}
