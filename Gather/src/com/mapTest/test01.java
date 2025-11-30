package com.mapTest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map接口常用方法
 * */
public class test01 {
    public static void main(String[] args) {
        //创建一个Map集合： 无序 唯一
        Map<String,Integer> map = new HashMap<>();
        //添加数据
        map.put("lili",100);
        map.put("zhansan",100);
        map.put("feifei",123);
        System.out.println(map);
        //删除数据
        map.remove("feifei");
        System.out.println(map);
        //查
        //containsKey(Object key)  如果此映射包含指定键的映射，则返回 true 。
        System.out.println(map.containsKey("zhansan"));
        //containsValue(Object value) 如果此地图将一个或多个键映射到指定值，则返回 true 。
        System.out.println(map.containsValue(123));
        //改 replace(K key, V value) 只有当目标映射到某个值时，才能替换指定键的条目。
        System.out.println(map);
        map.replace("lili",34567);
        map.replace("zhangsan",5647);
        System.out.println(map);

        Map<String,Integer> map1 = new HashMap<>();
        map1.put("wuer",3432);
        map1.put("dada",435);
        map1.put("hduia",789);
        //使用equal进行重写，比较集合中的值是否一样
        System.out.println(map.equals(map1));
        System.out.println("判断集合是否为空"+map1.isEmpty());

        System.out.println("--------对集合进行遍历查看--------");
        //使用KeySet() 对集合中的Key进行遍历查看
        Set<String> set = map.keySet(); //对集合的Key进行遍历查看
        for (String e : set){
            System.out.println(e);
        }
        //使用values()对集合中的values()进行遍历查看
        Collection<Integer> col=map.values();
        for (Integer i : col){
            System.out.println(i);
        }

        //entrySet() 返回此地图中包含的映射的Set视图。
        //Set<Map.Entry<K,V>> entrySet()->获取Map集合中的键值对,转存到Set集合中
        Set<Map.Entry<String,Integer>> en = map1.entrySet();
        for (Map.Entry<String,Integer> e :en){
            System.out.println(e);
        }

    }
}
