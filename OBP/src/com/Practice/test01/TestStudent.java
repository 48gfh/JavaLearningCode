package com.Practice.test01;

/**
 * toString() 方法
 * */

public class TestStudent {
    public static void main(String[] args) {
        int a =10;
        System.out.println(a);
        //创建一个Student类的具体的实列
        Student s1 =new Student("菲菲",19,50);
        System.out.println(a);
        System.out.println(s1);
        System.out.println(s1.toString());
    }
}
