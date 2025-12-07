package com.Practices;

import java.io.*;

/**
 * 使用FileOutputStream和FileInputStream复制一张图片
 * */
public class test03 {
    public static void main(String[] args) throws IOException {
        //源文件
        File file = new File("D:\\Desktop\\testD\\source.jpg");
        FileInputStream fileInputStream=new FileInputStream(file);
        //目标文件
        File file1 = new File("D:\\Desktop\\testD\\target.jpg");
        FileOutputStream fileOutputStream=new FileOutputStream(file1);
        //使用字节建议缓冲数组
        byte[] bytes = new byte[1024];
        int data = fileInputStream.read(bytes);
        while (data!=-1){
            fileOutputStream.write(bytes,0,data);
           data= fileInputStream.read(bytes);
        }
        System.out.println("复制完毕");
        fileInputStream.close();
        fileOutputStream.close();
    }
}
