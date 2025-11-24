package com.colle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 如何实现Collection 以及Collection常用方法：创、删、查、改
 * */
public class test01 {
    public static void main(String[] args) {
        //Collection为接口不能直接创建对象，利用实现类创建对象
        Collection cal =new ArrayList();
        /**
         * 添加数据： 集合中有一个特点只能存放引用数据类型的数据，不能是基本数据类型
         */
        cal.add(10); //基本数据类型会自动装箱
        cal.add("hello");
        cal.add("word");
        cal.add(11);
        cal.add(32432);
        System.out.println(cal.add("Test")); //添加成功会返回True
        List list = Arrays.asList(new Integer[]{11,22,33,44,55});//通过Arrays.asList将该数组转为固定大小的List集合
        cal.addAll(list); //将一个集合添加入cal
        System.out.println(cal);

        /**
         * 删
         * */
        //cal.clear();//从此集合中删除所有元素（可选操作）。
        System.out.println("集合是否为空"+cal.isEmpty());//如果此集合不包含元素，则返回 true 。
        System.out.println("集合中元素的数量为"+cal.size());

        // remove(Object o) 从该集合中删除指定元素的单个实例（如果存在）（可选操作）。
        System.out.println(cal);
        cal.remove("hello");
        System.out.println("查看是否移除 hello 字符串"+cal);
        //removeAll(Collection<?> c) 删除指定集合中包含的所有此集合的元素（可选操作）。
        cal.removeAll(list);
        System.out.println("从集合中是否删除list集合有关的数据"+cal);

        Collection col1=new ArrayList();
        col1.add(56);
        col1.add(90);
        col1.add(56);
        System.out.println(col1);
        Collection col2 =new ArrayList();
        col2.add(34);
        col2.add(54);
        col2.add(90);
        System.out.println(col2);

        Collection col3 =new ArrayList();
        col3.add(34);
        col3.add(54);
        col3.add(90);

        System.out.println(col1.equals(col2));
        System.out.println(col1 == col2);
        System.out.println(col2.equals(col3));
    }
}
