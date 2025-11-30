package com.practice.ArrLis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test05 {
    /**
     * 找出数字为30的索引并返回
     * */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(10,20,30,40,50));
        System.out.println(list);
        System.out.println("元素下表为30的索引是"+list.indexOf(30));
        /**
         * 给集合中每个元素乘2并输出结果
         * */
        //使用增强for循环
        for(Integer it:list){
            System.out.println((it * 2));
        }
        //使用迭代器
        Iterator<Integer> lis2 = list.iterator();
        while (lis2.hasNext()){
            Integer data = lis2.next();
            System.out.println("使用迭代器给集合中每个元素*2"+data*2);
        }

    }
}
