package com.practice.ArrLis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class test02 {
    public static void main(String[] args) {
        /**
         * 给定一个包含字符串的ArrayList，编写一个方法来删除所有包含字母b的元素
         * */
        ArrayList<String> str =new ArrayList<>();
        str.add("hello");
        str.add("word");
        str.add("java");
        str.add("bfsdfs");
        str.add("bdjoa");
        str.add("Python");
        System.out.println("ArrayList集合中的元素"+str);
        //removeIf(Predicate<? super E> filter) 删除满足给定谓词的此集合的所有元素。
        str.removeIf(s -> s.contains("b"));
        System.out.println("删除后的集合"+str);

        /**
         * 对ArrayList进行反转，并输出反转后的ArrayList 推荐使用Collections
         * */
       Collections.reverse(str);
        System.out.println("反转后列表元素的输出顺序"+str);


    }
}
