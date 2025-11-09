package com.FinalPractice.test01;

import java.util.Arrays;

//final 修饰变量
public class FianlVariable {
    //静态常量
    public  static final String appName = "XiaoMi";
    public  static final double PI =3.1415926;

    //实列常量
    private final int id;
    private final String createdAt;

    public FianlVariable(int id) {
        //final 实列变量必须在构造函数中初始化
        this.id = id;
        this.createdAt = java.time.LocalDateTime.now().toString();


    }



    public void  startFinalVar(){
        //fianl 局部变量
        final String message="这是一个局部变量";
        final int[] numbers= {1,2,3,4,5};


        System.out.println("final修饰变量演示");
        System.out.println("静态常量"+appName);
        System.out.println("实列常量"+id);
        System.out.println("实列常量 创建时间"+createdAt);
        System.out.println("局部final变量"+message);

        //尝试修饰final变量 移除著时候会出现报错
        /* id =10;
        message="hello word"*/

        numbers[0]=10;// 允许修改数组中的元素
        System.out.println(Arrays.toString(numbers));
        /*numbers = new int[3];*/ //不能重新分配引用


    }

    public static void main(String[] args) {
        FianlVariable example=new FianlVariable(1);
        example.startFinalVar();
        System.out.println(PI);
    }

}
