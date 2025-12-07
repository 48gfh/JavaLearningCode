package com.FileBufferStream;

import java.io.*;

/**
 * 缓冲字符流完成文本文件复制
 * */
public class test02 {
    public static void main(String[] args) throws IOException {
        //源文件
        File file1 = new File("D:\\Desktop\\Test\\ttt1.txt");
        //目标文件
        File file2 = new File("D:\\Desktop\\Test\\ttt1copy.txt");
        //字符流
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        //使用缓冲字符流加强
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        BufferedWriter  bufferedWriter= new BufferedWriter(fileWriter);
        //写入方法一
        /*int data;
        while ((data=bufferedReader.read())!=-1){
            bufferedWriter.write(data);
        }*/
        //写入方法二  利用缓存数组
        char[] chars = new char[1024];
        int data=bufferedReader.read(chars);
        while (data!=-1){
            bufferedWriter.write(chars,0,data);
            data=bufferedReader.read(chars);
        }
        System.out.println("复制成功");
        bufferedWriter.close();
        bufferedReader.close();


    }
}
