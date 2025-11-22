package com.Lis;

import java.util.ArrayList;

/**
 * ArrayList创建及基本使用方法
 * */
public class test01 {
    public static void main(String[] args) {
        // 创建ArrayList
        ArrayList list =new ArrayList();

        //添加元素 add(E e) 将指定的元素追加到此列表的末尾。
        list.add("Fruit");
        list.add("Banana");
        list.add("Orange");
        list.add("Watermelon");
        //在指定位置插入元素  add(int index, E element) 在此列表中的指定位置插入指定的元素。
        list.add(1,"hello");
        System.out.println("打印列表"+list);

        //获取元素 get(int index) 返回此列表中指定位置的元素
        System.out.println("第一个元素"+list.get(0));
        System.out.println("这也是一个获取第一个元素"+list.getFirst());
        System.out.println("获取最后一个元素"+list.getLast());

        //修改元素 set(int index, E element) 用指定的元素替换此列表中指定位置的元素。
        list.set(1,"芒果");
        list.set(3,"西瓜");
        System.out.println("修改后的列表"+list);

        // 删除元素
        list.remove("芒果");
        System.out.println(list);

        //获取列表
        System.out.println(list.size());

        //检查是否包含某种元素
        System.out.println(list.contains("西瓜"));

        //判断列表是否为空
        System.out.println(list.isEmpty());

        //遍历
        for (Object e:list){
            System.out.println(e);
        }

        // 创建一个表并且将另一个表添加上去
        ArrayList<String> anotherList = new ArrayList<>();
        anotherList.add("Pineapple");
        anotherList.add("Watermelon");
        anotherList.add("Strawberry");

        list.addAll(anotherList);
        System.out.println("添加另一个列表后: " + list);

        list.add("Kiwi");
        list.add("Peach");
        System.out.println("当前列表: " + list);
        System.out.println("子列表(1-3): " + list.subList(1, 3));


    }
}
