package com.FileByteStream;

import java.io.*;

/**
 * 使用FileInputStream和FileOutputStream完成非文本复制
 **/
public class test02 {
    public static void main(String[] args) throws IOException {
        //源文件
        File file = new File("D:\\Desktop\\Test\\picture.jpg");
        //目标文件
        File file1 = new File("D:\\Desktop\\Test\\picture_copy.jpg");
        //使用FileInputStream 字符流读取源文件
        FileInputStream inputStream = new FileInputStream(file);
        //使用FileOutputStream字符流写入目标文件
        FileOutputStream outputStream = new FileOutputStream(file1);
        //开始复制边读边写
        int n  = inputStream.read();
        while (n!=-1){
            outputStream.write(n);
            n= inputStream.read();
        }
        System.out.println("复制完成");
        outputStream.close();
        inputStream.close();
    }
}
