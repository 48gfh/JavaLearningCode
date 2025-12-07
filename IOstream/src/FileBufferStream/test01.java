package com.FileBufferStream;

import java.io.*;

/**
 *缓冲流：可以内部缓冲区域减少I/O读写次数
 * BufferedInputStream复制非文本文件
 * */
public class test01 {
    public static void main(String[] args) throws IOException {
        //源文件
        File file1 = new File("D:\\Desktop\\Test\\picture.jpg");
        //目标文件
        File file2 = new File("D:\\Desktop\\Test\\picture_copy.jpg");
        //使用字节流
        FileInputStream fileInputStream=new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);
        //使用缓冲流加强字节流
        BufferedInputStream bufferedInputStream= new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        int data;
        while ((data=bufferedInputStream.read())!=-1){
            bufferedOutputStream.write(data);
        }
        System.out.println("写入完成");
        bufferedOutputStream.close();
        bufferedInputStream.close();

    }
}
