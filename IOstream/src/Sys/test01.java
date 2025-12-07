package com.Sys;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

//System.in  默认情况下从键盘输入
//System.out 默认情况下输出到控制台
public class test01 {
    public static void main(String[] args) throws IOException {
        //得到标准的输入流 从键盘输入
        InputStream in =System.in;
        int n= in.read();
        //Scanner相当于一个扫描器
        Scanner sc = new Scanner(new FileInputStream(new File("D:\\Desktop\\Test\\ttt1.txt")));
        while (sc.hasNext()){
            System.out.println(sc.next());
        }
    }
}
