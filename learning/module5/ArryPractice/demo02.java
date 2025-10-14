package com.learning.module5.ArryPractice;

import java.util.Random;

public class demo02 {
    public static void main(String[] args) {
        //随机生产10个[0~100]之间的整数，统计即是3又是5的倍数，但不是7的倍数个数
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            Random  randomNum = new Random();
            arr[i]=randomNum.nextInt((100)+1);
           // System.out.println("arr中的数据为："+arr[i]);
            if((arr[i]%3==0&&arr[i]%5==0)&&arr[i]%7!=0){
                System.out.println(arr[i]);
            }
        }

    }
}
