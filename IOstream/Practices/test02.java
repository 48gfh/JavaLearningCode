package com.Practices;

import java.io.*;
/**
 * 使用BufferedReader和BufferedWriter按行读取源文本内容，在每行前添加行号
 * */
public class test02 {
    public static void main(String[] args) throws IOException {
        //源文件
        File file = new File("D:\\Desktop\\testD\\input.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader);

        //目标文件
        File file1 = new File("D:\\Desktop\\testD\\Output.txt");
        FileWriter fileWriter = new FileWriter(file1);
        BufferedWriter bufferedWriter =  new BufferedWriter(fileWriter);

        String s = bufferedReader.readLine();
        int line =0;
        while (s!=null){
            //(++line)在while每次读取一行内容之前line会自增1 (++line+s)将行号读取的字符串与行号进行拼接再写入目标文件
            bufferedWriter.write(++line+s);
            bufferedWriter.newLine();
            s=bufferedReader.readLine();
        }
        System.out.println("复制完毕");
        bufferedWriter.close();
        bufferedReader.close();

    }
}
