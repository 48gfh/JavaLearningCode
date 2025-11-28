package com.setTest.hshSet;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 放入自定义的数据类型
 * */
public class test03 {
    public static void main(String[] args) {
        //创建一个HashSet集合
        HashSet<Student> st =new HashSet<>();
        st.add(new Student("zhangsan",34));
        st.add(new Student("lisi",45));
        st.add(new Student("wanger",23));
        System.out.println(st.size());
        System.out.println(st);

    }
}
