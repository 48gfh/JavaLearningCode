package com.FileByteStream;

import java.io.*;


/**
 * 利用缓冲字节数组完成边读编写
 * */
public class test03 {
    public static void main(String[] args) throws IOException {
        //准备源文件与目标文件
        File file = new File("D:\\Desktop\\Test\\picture.jpg");
        File file1 = new File("D:\\Desktop\\Test\\picture_copy.jpg");
        //准备字节流
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(file1);
        //创建字节数组作为缓冲区
        byte[] bytes = new byte[1024];
        int len;
        //循环读取并写入
        while ((len= inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }
        outputStream.close();
        inputStream.close();
    }
}
