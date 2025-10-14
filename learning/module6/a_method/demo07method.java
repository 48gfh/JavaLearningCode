package com.learning.module6.a_method;

public class demo07method {
    //需求:定义一个方法,比较两个整数的大小,如果第一个比第二个大,返回true,否则返回false
    public static void main(String[] args) {
        boolean result = compare(34,45);
        System.out.println("result="+result);

    }
    public static boolean compare(int a,int b){
        if(a>b){
            return true;
        }else {
            return false;
        }
    }
}
