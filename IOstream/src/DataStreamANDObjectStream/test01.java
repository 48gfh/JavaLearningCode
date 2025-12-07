package com.DataStreamANDObjectStream;

import java.io.*;

/** 注意 写入的类型跟读入的类型必需匹配
 * DataInputStream将文件存储的基本数据类型和字符串 写入 内存变量之中
 * DataOutputStream 将内存中的基本数据类型和字符串的变量 写出 文件中
 * */
public class test01 {
    public static void main(String[] args) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File("D:\\Desktop\\Test\\picture.jpg")));
        dataOutputStream.writeInt(45);
        dataOutputStream.writeBoolean(false);
        dataOutputStream.close();

        DataInputStream dataInputStream= new DataInputStream(new FileInputStream(new File("D:\\Desktop\\Test\\picture.jpg")));
        //将文件内容读取
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readBoolean());
        dataInputStream.close();
    }
}
