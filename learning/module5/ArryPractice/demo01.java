package com.learning.module5.ArryPractice;

public class demo01 {
    public static void main(String[] args) {
        //求出数组中最大的数字
        int arr1[]= {10,23,45,44444,43,33,45,13,45,122};
        int Max = 0;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i]>Max){
                Max = arr1[i];
            }
        }
        System.out.println("arr1最大数为"+Max);
    }
}
