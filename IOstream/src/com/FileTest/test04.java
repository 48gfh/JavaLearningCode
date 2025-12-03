package com.FileTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter() 类是用于写入文本文件的字符流类。它继承自OutputStreamWriter，而OutputStreamWriter继承自Writer
 * */
public class test04 {
    public static void main(String[] args) throws IOException {
        File file= new File("D:\\Desktop\\test02.txt");
        //FileWriter 将字符输出到目标文件上
        FileWriter fileWriter = new FileWriter(file);
        //开始输出动作，将字符一点点输出
        String   str="hello javaj fhuidisfhgiosdfgiosgdfiols";
        for (int i = 0; i < str.length(); i++) {
            fileWriter.write(str.charAt(i));
        }
        fileWriter.close();

    }
}
