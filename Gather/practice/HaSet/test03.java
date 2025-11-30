package com.practice.HaSet;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * 给定一个整数数组，去重并按照降序排序
 * */
public class test03 {
    public static void main(String[] args) {
        Integer arr[]={1,2,3,3,4,4,45,5,5,5,52,1,2,3,3,344,54,3453};
        TreeSet<Integer> dadad = new TreeSet<>();
        System.out.println(dadad.addAll(List.of(arr)));
        System.out.println(dadad);

    }




}
