package com.pratice.test01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 数组越界异常:随机生成一个长度5的数组，让用户输入索引，打印对应元素
 * */
public class ArrayIndexDemo {
    public static void main(String[] args) {
        int [] data =new int[5];
        for (int i = 0; i < data.length; i++) {
            Random rd =new Random();
            data[i]= rd.nextInt();
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入0-4之间");
        try{
            int ch = sc.nextInt();
            System.out.println("对应的元素为"+data[ch]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("下标越界，有效范围是0-4");
        } catch (Exception e) { //防止出现非整数
            System.out.println("输入格式错误"+e.getMessage());
        }finally {
            sc.close();
        }

    }
}
