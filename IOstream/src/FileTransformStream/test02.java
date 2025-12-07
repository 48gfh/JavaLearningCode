package com.FileTransformStream;

import java.io.*;


/**
 * 使用转换流对文本实现复制
 * */
public class test02 {
    public static void main(String[] args) throws IOException {
        //源文件
        File file1 = new File("D:\\Desktop\\Test\\ttt1.txt");
        //目标文件
        File file2 = new File("D:\\Desktop\\Test\\ttt1copy.txt");
        //输入方向
        FileInputStream fileInputStream=new FileInputStream(file1);
        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream,"utf-8");
        //输出方向
        FileOutputStream fileOutputStream=new FileOutputStream(file2);
        OutputStreamWriter outputStreamWriter =  new OutputStreamWriter(fileOutputStream,"utf-8");
        //利用数组缓存批量处理
        int data;
        char[] chars = new char[1024];
        while ((data=inputStreamReader.read(chars))!=-1){
            outputStreamWriter.write(chars,0,data);
        }
        System.out.println("复制完成");
        outputStreamWriter.close();
        inputStreamReader.close();


    }
}
