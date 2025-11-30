package com.practice.ArrLis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class test04 {
    public static void main(String[] args) {
        /**
         * 给定两个包含整数的ArrayList,编写一个方法来合并这两个ArrayList，并去重和排序
         * */
        ArrayList<Integer> num = new ArrayList<>();
        num.add(212);
        num.add(2131);
        num.add(23);
        num.add(768);
        num.add(213);
        num.add(111222);
        ArrayList<Integer> num1 = new ArrayList<>();
        num1.add(12);
        num1.add(2131);
        num1.add(23);
        num1.add(768);
        num1.add(213);
        num1.add(67);
        num1.add(231);
        System.out.println("查看第一个集合"+num);
        System.out.println("查看第二个集合"+num1);
        //合并这两个集合
        System.out.println(num.addAll(num1));
        System.out.println(num);
        //对合并的集合进行去重和排序

        // TreeSet 会自动排序且去重
        TreeSet<Integer> sortedSet = new TreeSet<>(num);
        System.out.println("排序后的元素: " + sortedSet);



    }
}
