package com.setTest.hshSet;

import java.util.HashSet;

/**
 *在HashSet中放入String类型
 * */
public class test02 {
    public static void main(String[] args) {
        //创建一个HashSet集合
        HashSet<String> hs = new HashSet();
        hs.add("hello");
        hs.add("word");
        hs.add("java");
        hs.add("c");
        System.out.println(hs.size());
        System.out.println(hs);

    }
}
