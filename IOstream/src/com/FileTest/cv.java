package com.FileTest;

import java.io.*;

/**
 * 使用java完成文件复制操作
 * */
public class cv {
    public static void main(String[] args) throws IOException {
        //创建读取文件
        File rFile = new File("D:\\Desktop\\test01.txt");
        //创建写入文件
        File wFile = new File("D:\\Desktop\\test02.txt");
        //使用FileReader读取文件
        FileReader fileReader = new FileReader(rFile);
        //s使用FileWriter写入文件
        FileWriter fileWriter = new FileWriter(wFile);
        int character;
        while ((character=fileReader.read())!=-1){
            fileWriter.write(character);
        }
        System.out.println("复制完成");
        fileWriter.close();
        fileReader.close();
    }
}
