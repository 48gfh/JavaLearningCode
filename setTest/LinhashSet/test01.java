package com.setTest.LinhashSet;

import java.util.LinkedHashSet;

public class test01 {
    public static void main(String[] args) {
        //创建一个LinkedHashSet集合
        LinkedHashSet<Integer> hs = new LinkedHashSet<>();
        hs.add(34);
        hs.add(67);
        hs.add(89);
        hs.add(56);
        System.out.println(hs);
        System.out.println(hs.size());
        System.out.println(hs.add(34));
        System.out.println(hs);
        System.out.println(hs.size());
    }
}
