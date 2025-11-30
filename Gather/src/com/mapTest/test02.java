package com.mapTest;

import java.util.HashMap;

public class test02 {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        //V put(K key, V value)  -> 添加元素,返回的是被覆盖的value
        map.put("zhangsan","lisi");
        System.out.println(map.put("wanger", "hudsisa"));
        System.out.println(map);
        System.out.println("--------------");
        //V remove(Object key)  ->根据key删除键值对,返回的是被删除的value
        String value3 = map.remove("zhangsan");
        System.out.println(value3);
        System.out.println(map);
    }
}
