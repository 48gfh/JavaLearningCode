package com.Practices;

import java.io.*;

/**
 *使用FileWriter和FileReader，将一个文本复制到另一个文本中
 * */
public class test01 {
    public static void main(String[] args) throws IOException {
        //源文件
        File file = new File("D:\\Desktop\\testD\\input.txt");
        FileReader fileReader = new FileReader(file);
        //目标文件
        File file1 = new File("D:\\Desktop\\testD\\Output.txt");
        FileWriter fileWriter = new FileWriter(file1);

        //使用char数组批量复制
        char[] chars = new char[1024];
        int data = fileReader.read(chars);
        while (data!=-1){
            fileWriter.write(chars,0,data);
            data= fileReader.read(chars);
        }


       /* int data;
        while ((data= fileReader.read())!=-1){
            fileWriter.write(data);
        }*/
        System.out.println("复制完毕");
        fileWriter.close();
        fileReader.close();
    }
}
