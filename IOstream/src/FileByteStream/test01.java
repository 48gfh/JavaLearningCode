package com.FileByteStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 字节流：主要用于处理字节数据，如图片、音频、视频等二进制文件
 * 使用FileInputStream读取文件中的内容
 * */
public class test01 {
    public static void main(String[] args) throws IOException {
        //文件源
        File file = new File("D:\\Desktop\\Test\\picture.jpg");
        //使用字节流读取源文件
        FileInputStream fileInputStream = new FileInputStream(file);
        int n = fileInputStream.read();
        /**
         * read()在读取的字节的时候返回值都是int而不是Byte read方法底层做了处理
         * */
        while (n!=-1){
            System.out.println(n);
            n =fileInputStream.read();
        }
        fileInputStream.close();


    }
}
