package com.learning.module6.a_method;

public class demo01method {
    public static void main(String[] args) {
        farmer();
        System.out.println("============");
        cook();
        System.out.println("=============");
        farmer();
        System.out.println("==================");
        custome();

    }
    public  static  void farmer(){
        System.out.println("播种");
        System.out.println("施肥");
        System.out.println("拔草");
        System.out.println("除虫");
        System.out.println("收割");
    }
    public static void  cook() {
        System.out.println("洗菜");
        System.out.println("切菜");
        System.out.println("炒菜");
        System.out.println("装菜");
        System.out.println("上菜");
    }

    public static  void custome(){
        System.out.println("洗手");
        System.out.println("吃饭");
    }

}
