package com.practice.HaSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 创建一个HashSet并且移除集合中的所有偶数
 * */
public class test02 {
    public static void main(String[] args) {
        HashSet<Integer> hset=new HashSet<>(Set.of(12,3,4,5,6,78,23,4535,142));
        System.out.println(hset);
        for (Iterator<Integer> iterator= hset.iterator();iterator.hasNext();) {
            if(iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(hset);

    }
}
