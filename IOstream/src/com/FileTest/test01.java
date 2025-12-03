package com.FileTest;

import java.io.File;

/**
 * File类对文件的常用操作
 * */
public class test01 {
    public static void main(String[] args) {
        //将文件封装为File对象
        File  f = new File("E:\\Code_Repositories\\JavaSE_code\\IOstream\\src\\com\\TestDirectory");
        //File.separator 属性帮我们获取当前操作系统的路径拼接符号 使用File.separator 实现跨平台兼容
        File f1 = new File("E:"+File.separator+"Code_Repositories"+File.separator+"JavaSE_code"+File.separator+"IOstream+");
        //常用方法
        System.out.println("查看文件是否可读"+f1.canRead());
        System.out.println("查看文件是否可写"+f.canWrite());
        System.out.println("查看文件的上级目录"+f1.getParent());
        System.out.println("查看文件是否是一个目录"+f1.isDirectory());
        System.out.println("查看文件是大小"+f.length());
        System.out.println("查看文件大小"+f1.length());
        System.out.println("查询该对象是否是文件"+f.isFile());
        System.out.println("比较两对象路径"+(f == f1));

        //与路径相关
        System.out.println("获取绝对路径"+f.getAbsolutePath());
        System.out.println("获取相对路径"+f.getPath());


    }
}
