package com.StrClass;
/**
 * StringBuilder 可在对象地址不变的情况下修改字符串
 * */
public class test02 {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder("dada");
        //增
        System.out.println(sb.append("hello"));
        System.out.println(sb);
        //删
        sb.delete(2,3);//删除范围上的字符
        System.out.println(sb);

        sb.deleteCharAt(4);
        System.out.println(sb);//删除指定索引位置上的字符

        //插入数据
        sb.insert(3,"fghjsfguis");
        System.out.println(sb);//在下标为3 的位置上插入数据
        //更换
        sb.replace(0,3,"helloword");
        System.out.println(sb);

        //查
        StringBuilder str4 =new StringBuilder("testsete@@");
        for (int i = 0; i < str4.length(); i++) {
            System.out.println(str4.charAt(i));

        }
    }
}
