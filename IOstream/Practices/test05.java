package com.Practices;

import java.io.*;

/**
 *使用InputStreamReader(转换流)读取utf-8编码的文件，并以GBK编码写入gbk.txt文件
 * */
public class test05 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("D:\\Desktop\\testD\\input.txt")),"utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("D:\\Desktop\\testD\\gbk.txt")),"GBK"));
        while (line!=null){
            System.out.println(line);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            line= bufferedReader.readLine();
        }
        System.out.println("复制完毕");
        bufferedWriter.close();
        bufferedReader.close();


    }
}
