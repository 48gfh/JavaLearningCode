package com.practice.ArrLis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class test03 {
    public static void main(String[] args) {
        /**
         * 给定一个包含整数的ArrayList，编写一个方法来找出最大元素
         * */
        ArrayList<Integer> num = new ArrayList<>();
        num.add(212);
        num.add(2131);
        num.add(23);
        num.add(768);
        num.add(213);
        System.out.println(num);
        //方法一 利用增强for循环遍历进行比较
        Integer maxNumber=0;
        for(Integer da: num){
            if(maxNumber<da){
                maxNumber=da;
            }
        }
        System.out.println("ArrayList集合中最大元素为"+maxNumber);
        //方法二 使用迭代器遍历
        if(!num.isEmpty()){
            Iterator<Integer> iterator  = num.iterator();
            Integer maxdata = iterator.next();
            while (iterator.hasNext()){
                Integer current = iterator.next();
                if(maxNumber<current){
                    maxNumber=current;
                }
            }
            System.out.println("ArrayList集合中最大的数字为"+maxNumber);
        }
        //方法三 Collections.max()
        Integer max = Collections.max(num);
        System.out.println("ArrayList集合中大的元素为"+max);
    }
}
