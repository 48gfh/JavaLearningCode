package com.mapTest;

import java.security.Key;
import java.util.HashMap;
import java.util.Scanner;

/**
 *需求:用Map集合统计字符串中每一个字符出现的次数
 * 步骤:
 *   1.创建Scanner和HashMap
 *   2.遍历字符串,将每一个字符获取出来
 *   3.判断,map中是否包含遍历出来的字符 -> containsKey
 *   4.如果不包含,证明此字符第一次出现,直接将此字符和1存储到map中
 *   5.如果包含,根据字符获取对应的value,让value++
 *   6.将此字符和改变后的value重新保存到map集合中
 *   7.输出
 *
 * */
public class test03 {
    public static void main(String[] args) {
        //创建Scanner和HashMao
        Scanner sc = new Scanner(System.in);
        HashMap<String,Integer>  hs= new HashMap<>();
        String inputData= sc.next();
        char[] chars=inputData.toCharArray();
        for(char aChar:chars){
            String key =aChar+"";
            if (!hs.containsKey(key)){
                hs.put(key,1);
            }else {
                Integer value = hs.get(key);
                value++;
            }
        }
        System.out.println(hs);
    }
}
