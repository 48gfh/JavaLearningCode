package com.practice.HaMap;

import java.util.HashMap;

/**
 * 检查hashMap中是否包含某个键或值
 * */
public class test02 {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"hello");
        hashMap.put(2,"java");
        hashMap.put(3,"python");
        hashMap.put(4,"c++");
        hashMap.put(5,"scala");
        System.out.println(hashMap.containsKey(1));
        System.out.println(hashMap.containsValue("java"));

    }
}
