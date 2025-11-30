package com.practice.ArrLis;

import java.util.ArrayList;

/**
 * 1、ArrayList练习题1 定义一个ArrayList并添加以下元素 1 2 3 4 5 然后使用循环遍历并打印所有元素
 * 2、移除索引为2的元素，并输出修改后的ArrayList
 * 3、给定一个包含整数的ArrayList，编写一个程序计算所有元素之和
 * */
public class test01 {
    public static void main(String[] args) {
        //定义一个ArrayList
        ArrayList<Integer> el = new ArrayList<>();
        //给ArrayList中添加元素
        el.add(1);
        el.add(2);
        el.add(3);
        el.add(4);
        //使用增强for循环遍历
        for(Integer e:el){
            System.out.println(e);
        }
        //移除索引为2的元素，并输出修改后的ArrayList
        el.remove(2);
        System.out.println("移除索引为2的元素后集合"+el);

        //给定一个包含整数的ArrayList，编写一个程序计算所有元素之和
        el.add(34);
        el.add(23);
        int data1=0;
        for(Integer data:el){
            System.out.println(data);
            data1 =((int)data)+data1;
        }
        System.out.println("ArrayList中的集合元素总和为:"+data1);
        //针对上一题进行的优化
        int Sum=0;
        for (Integer data3:el){
            Sum+=data3;//简化了累加操作
        }
        System.out.println("ArrayList中的元素总和为"+Sum);

    }
}
