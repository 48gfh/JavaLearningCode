package com.practice.HaSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 判断HashSer中是否包含某个元素
 * */
public class test01 {
    public static void main(String[] args) {
        HashSet<String> hset= new HashSet<>(Set.of("hello","java","map","reduce","python","C++","word","scala","conda","hadoop"));
        System.out.println(hset);
        System.out.println(hset.contains("java"));
        /**
         * 从HashSet中删除元素后再次输出集合
         * */
        System.out.println(hset.remove("hello"));
        System.out.println("删除元素后的的HashSet中的集合元素为"+hset);
        /**
         * 遍历HashSet中的集合
         * */
        //使用增强for循环遍历
        for(String str: hset){
            System.out.println(str);
        }
        //使用遍历器
        Iterator<String>  it = hset.iterator();
        while (it.hasNext()){
            System.out.println("使用遍历器遍历HashSet集合"+it.next());
        }


    }
}
