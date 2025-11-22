package com.colle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 如何再Collection中遍历
 * */
public class test02 {
    public static void main(String[] args) {
        Collection cal =new ArrayList();
        /**
         * 添加数据： 集合中有一个特点只能存放引用数据类型的数据，不能是基本数据类型
         */
        cal.add(10); //基本数据类型会自动装箱
        cal.add("hello");
        cal.add("word");
        cal.add(11);
        cal.add(32432);
        cal.add(26347832);
        cal.add(45334);
        //方法一 使用增强for循环
        for (Object e:cal){
            System.out.println(e);
        }
        System.out.println("-----------使用迭代器进行循环-----------");
        //方法二 使用迭代器循环   iterator() 返回此集合中的元素的迭代器。
        Iterator it = cal.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
