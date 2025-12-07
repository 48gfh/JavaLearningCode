package com.FileTransformStream;

import java.io.*;

/** 转换流
 * 作用：将字节流和字符流进行转换 属于字符流
 * InputStreamReader 字节输入流 -> 字符输入流
 * OutputStreamWriter 字符输出流 -> 字节的输出流
 * */
public class test01 {
    public static void main(String[] args) throws IOException {
        //源文件
        File file1 = new File("D:\\Desktop\\Test\\ttt1.txt");
        //需要一个字节流接触文件
        FileInputStream fileInputStream=new FileInputStream(file1);
        //加入一个转换流，将字节流转为字符流。需要一个指定的编码格式必须与原文统一
        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream,"utf-8");
        //将读取的内容在文字台输出
        char[] chars = new char[1024];
        int data;
        while ((data=inputStreamReader.read())!=-1){
            System.out.print((char) data);
        }
        inputStreamReader.close();

    }
}
