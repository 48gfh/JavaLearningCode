package com.practice.HaMap;

import java.util.HashMap;

/**
 * 给定一个整数数组，找出数组中每个元素对应出现的次数
 * */
public class test04 {
    public static void main(String[] args) {
        Integer arr[]={1,2,3,4,54,3,4,5,65,2,343,4,2,1,1};
        HashMap<Integer,Integer> hashMap =new HashMap<>();
        //遍历数组统计每个元素出现的次数
        for(Integer num:arr){
            hashMap.put(num, hashMap.getOrDefault(num,0)+1);

        }
        //统计打印结果
        System.out.println(hashMap);

    }
}
