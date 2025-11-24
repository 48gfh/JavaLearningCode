package com.Genericity;

import java.util.ArrayList;

/**
 * Java中泛型
 * */
public class test01 {
    public static void main(String[] args) {
        //没有泛型的时候使用集合
        //创建一个ArrayList集合并向集合中存入数据
        ArrayList al = new ArrayList();
        al.add(90);
        al.add(90);
        al.add(34);
        al.add(67);
        al.add("test");
        /**
         * 一般在使用集合的时候基本往集合中方存入的都是相同数据以便于管理
         * */

        //对集合使用增强for循环遍历
        for(Object o: al){
            System.out.println(o);
        }

        ArrayList <Integer> al1=new ArrayList<>();
        //加入泛型的优点：在编译时期会对类型进行检查，不是泛型对应的类型就不可以添加进集合
        al1.add(23);
        al1.add(45);
        al1.add(56);
        //对集合进行遍历
        for (Integer e:al1){
            System.out.println(e);
        }
    }
}
