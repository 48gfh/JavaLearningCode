package com.learning.module6.b_method;

public class demo02method {
    //在main方法中定义一个数组，将一个数组传递到另一个方法中并在此方法中遍历数组
    public static void main(String[] args) {
    int arr1[] = {1,2,3,4,54,5,6,67};
    traverse(arr1);
    }
    public static void traverse(int[] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]);
        }

    }

}
