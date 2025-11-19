package com.StrClass;

import java.util.Arrays;

public class test01 {
    public static void main(String[] args) {
        // 通过构造器来创建对象   构造器：底层就是给对象底层的value进行赋值
        String s1 = new String();
        System.out.println(s1);
        String s2 = new String("wrod");
        System.out.println(s2);
        String s3 = new String(new char[]{'h','e','l','l','o'});
        System.out.println(s3);

        //String类的常用方法
        String s4 = "helloWord";
        System.out.println("字符串的长度是"+s4.length());
        String s5 = new String("hello word");
        System.out.println("字符串是否为空"+s5.isEmpty());
        System.out.println("获取字符串下标对应的字符"+s5.charAt(3));

        //equals 进行两字符串进行比较
        String s6 = new String("hello");
        String s7 = new String("word");
        System.out.println(s6.equals(s7));
        //以下为实现字符串对的核心逻辑
      /*  public static boolean equals(byte[] value, byte[] other) {
            if (value.length == other.length) {// 如果两字节数组长度不相等直接为False
                for (int i = 0; i < value.length; i++) {
                    if (value[i] != other[i]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }*/

        //compareTo 按照字典顺序比较两个字符串
        System.out.println(s6.compareTo(s7));
        //compareTo源码逻辑
     /*   public int compareTo(String anotherString) {
            byte[] v1 = value;
            byte[] v2 = anotherString.value;
            byte coder = coder();//获取当前两个字符串的编码方式
            if (coder == anotherString.coder()) {
            // 如果都是 LATIN1 编码，使用 StringLatin1.compareTo 方法比较
        // 如果都是 UTF16 编码，使用 StringUTF16.compareTo 方法比较
                return coder == LATIN1 ? StringLatin1.compareTo(v1, v2)
                        : StringUTF16.compareTo(v1, v2);
            }
             // 如果两个字符串使用不同的编码方式
            // 使用相应的方法进行跨编码比
            return coder == LATIN1 ? StringLatin1.compareToUTF16(v1, v2)
                    : StringUTF16.compareToLatin1(v1, v2);
        }*/
        //常用的字符串方法
        //字符串的截取
        String  s10 = "ghyfusiahufiolasdf@hiosa";
        System.out.println(s10.substring(3)); //把下标3以后的字符串截取下来
        System.out.println(s10.substring(2, 9));//左闭右开 把下标2-9的字符串截取下来，但是取不到下标为9的
        //替换指定字符
        System.out.println(s10.replace("a", "tr"));
        //按照指定的字符进行分隔
        String[] str = s10.split("@");
        System.out.println(Arrays.toString(str));

        //转大写和转小写的方法
        //转大写
        System.out.println(s10.toUpperCase());
        System.out.println(s10.toLowerCase());



    }
}
