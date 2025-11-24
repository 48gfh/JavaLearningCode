package com.LiLis;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * LinkedList常用方法使用
 * */
public class test01 {
    public static void main(String[] args) {
        //实列化一个LinkedList集合对象
        LinkedList<String> list1= new LinkedList<>();
        //add(E e) 将指定的元素追加到此列表的末尾
        list1.add("java");
        list1.add("test");
        list1.add("hello");
        list1.add("word");
        list1.add("加油");
        System.out.println(list1);
        //add(int index, E element)  在指定位置上插入元素
        list1.add(0,"num1");
        System.out.println(list1);

        //offer(E e) 将指定的元素添加为此列表的尾部（最后一个元素）。
        list1.offer("last1");
        list1.offer("last2");
        list1.offerLast("last3");
        list1.offer("test2");//LinkedList可以添加重复元素
        System.out.println(list1);
        System.out.println("-------------------");
        System.out.println(list1.removeFirst());//在集合中删除并返回第一个元素
        System.out.println(list1.pollLast());//在集合列表中删除并返回最后一个元素
        System.out.println("--------------------");

        //集合的遍历
        //1、可以使用普通for循环遍历
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        //2、增强for循环
        for(String e:list1){
            System.out.println(e);
        }
        //3、使用迭代器
        /*for(Iterator<String> it =list1.iterator(); it.hasNext();){
            System.out.println(list1);
        }*/

    }
}
