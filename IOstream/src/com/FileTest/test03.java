package com.FileTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * FileRead 类是用于读取文本文件的字符流类。它继承自InputStreamReader，而InputStreamReader继承自Reader
 * */
public class test03 {
    public static void main(String[] args) throws IOException {
        File f = new File("D:\\Desktop\\test01.txt");
        FileReader fileReader =  new FileReader(f);//一个字符一个字符的读入
        //方式一
        int n = fileReader.read();
        while ((n= fileReader.read())!=-1){
            System.out.println((char) n);
        }
        //方式二
        int c;
        while ((c= fileReader.read())!=-1){
            System.out.println((char) c);
        }
        fileReader.close(); //关闭输入流  流、数据库、网络资源 靠jvm本身无法关闭，需手动关闭
    }
}
