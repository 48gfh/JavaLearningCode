package com.setTest.TreSet;

import java.util.TreeSet;

/**
 * TreeSet实现类的使用
 * */
public class test01 {
    public static void main(String[] args) {
        //创建一个TreeSet类
        TreeSet<Integer> tr=new TreeSet<>();
        tr.add(34);
        tr.add(67);
        tr.add(89);
        tr.add(56);
        System.out.println(tr.size());
        System.out.println(tr);
    }
}
