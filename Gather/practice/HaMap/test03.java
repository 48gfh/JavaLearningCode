package com.practice.HaMap;

import java.util.HashMap;

/**
 * 从HashMap中删除所有值为Null的键值对
 * */
public class test03 {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"hello");
        hashMap.put(2,"java");
        hashMap.put(3,null);
        hashMap.put(4,"c++");
        hashMap.put(5,"scala");
        System.out.println(hashMap.values().remove(null));
        System.out.println(hashMap);

    }
}
