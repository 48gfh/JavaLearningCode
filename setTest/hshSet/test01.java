package com.setTest.hshSet;
import java.util.HashSet;

/**
 * HashSet实现类的使用
 * 特点是 唯一性、无索引访问、无序性、允许空值
 * */

public class test01 {
    public static void main(String[] args) {
        //创建一个HashSet集合
        HashSet<Integer> hs = new HashSet<>();
        System.out.println(hs.add(99));
        hs.add(33);
        hs.add(789);
        hs.add(23);
        System.out.println(hs.add(99)); //返回false 这个99 不会放入集合
        System.out.println(hs);
    }
}
