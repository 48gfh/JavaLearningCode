package com.pratice.test01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileCount {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("请输入要统计的文件");
        String path= sc.nextLine();

        try {
            //BufferReader是java中用于高校读取文本文件的类，它内部使用缓冲来提高读取效率
            // FileReader 直接与文件建立  BufferedReader 包装FileReader为其添加缓冲
            BufferedReader br= new BufferedReader(new FileReader(path));
        }catch (FileNotFoundException e){
            System.out.println("输入文件路径有误");
        }catch (IOException e){
            System.out.println("读取文件未找到"+e.getStackTrace());
        }
        finally {
            sc.close();
        }

    }
}
