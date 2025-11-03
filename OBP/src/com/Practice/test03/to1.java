package com.Practice.test03;

import java.sql.SQLOutput;

/**
 * instanceof  二元操作符 用于检查对象是否属于特定类型
 * */
public class to1 {
    public static void main(String[] args) {
        //基本用法
        String s= "fhusihfhgsdiofhusihello";
        if (s instanceof String){
            System.out.println("s 是String 类型");
        }

        //继承关系检查
        Dog dog = new Dog();
        if(dog instanceof Animal){
            System.out.println("dog 是 animal 类型");
        }
    }
}
