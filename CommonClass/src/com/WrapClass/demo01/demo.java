package com.WrapClass.demo01;

public class demo {
    public static void main(String[] args) {
        //compareTo 只返回三个值 0，-1，1
        Integer data1 = Integer.valueOf(10);  //valueof 就是将  Integer --> Int
        Integer data2 = Integer.valueOf(20);
        System.out.println(data1.compareTo(data2));
        //源代码中实现的逻辑
        /*public static int compare(int x, int y) {
            return (x < y) ? -1 : ((x == y) ? 0 : 1);
        }*/
        System.out.println(data1==data2); //flase 是因为==是进行两个变量的地址
        System.out.println(data1==data1);

        //Interger中的equals进行了重写等操作
        boolean flag =data1.equals(data2);
        System.out.println(flag);

        //使用Interger自动装箱与自动拆箱
        Integer data3 =110; // 自动装箱
        Integer data4 =50;
        System.out.println(data3.equals(data4));
        /*
        * 自动装箱值范围是-128-127之间,那么比较的就是具体的数值否在，比较的就是对象的具体值
        * */

        Integer data5 =50;
        int data6 =data5.intValue();  //自动拆箱操作
        System.out.println(data6);






    }
}
