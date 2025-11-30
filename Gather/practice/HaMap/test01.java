package com.practice.HaMap;

import com.sun.jdi.Value;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建一个HashMap，并添加五个键值对，然后遍历打印所有的键值对
 * */
public class test01 {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"hello");
        hashMap.put(2,"java");
        hashMap.put(3,"python");
        hashMap.put(4,"c++");
        hashMap.put(5,"scala");
        //使用entrySet()遍历键值对
        for (Map.Entry<Integer,String> entry:hashMap.entrySet()){
            System.out.println("Key"+entry.getKey()+"Value"+entry.getValue());
        }
        //forEach(BiConsumer<? super K,? super V> action)  对此映射中的每个条目执行给定的操作，直到所有条目都被处理或操作引发异常。
        hashMap.forEach((Key, Value) -> System.out.println(Key+":"+Value));




    }
}
