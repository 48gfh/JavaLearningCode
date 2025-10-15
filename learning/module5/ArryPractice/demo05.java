package com.learning.module5.ArryPractice;

public class demo05 {
    public static void main(String[] args) {
        String[][] arr1 ={{"孙悟空","唐僧","沙和尚"},{"关羽","张飞","刘备"},{"武松","宋江"},{"林黛玉","贾宝玉"}};

        //遍历二维数组
        for (int i = 0; i < arr1.length; i++) {
            for (int i1 = 0; i1 < arr1[i].length; i1++) {
                System.out.println(arr1[i][i1]);
            }
        }
        
        
        
        
        
        /*        //分别获取数组里的元素
        System.out.println(arr1[0][0]);
        System.out.println(arr1[0][1]);
        System.out.println(arr1[0][2]);
        System.out.println(arr1[3][1]);*/
        
/*        //获取每一个数组的长度
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i].length);*/
        }



/*        //二位数组练习
        int [][] arr1 = new int[2][2];
        int  [][] arr2 = new int [2][];
        System.out.println("===========================");
        String[][] arr3 ={{"张三","李四"},{"王五","牛二"},{"二狗"},{}};*/
    }

