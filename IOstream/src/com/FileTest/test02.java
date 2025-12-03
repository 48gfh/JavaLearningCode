package com.FileTest;

import java.io.File;

/**
 * File对目录进行操作
 * */
public class test02 {
    public static void main(String[] args) {
        //将目录封装为File类对象
        File f = new File("E:\\Code_Repositories\\JavaSE_code\\IOstream\\src\\com\\TestDirectory");
        //常用方法
        System.out.println("文件是否可写"+f.canWrite());
        System.out.println("文件是否可读"+f.canRead());
        System.out.println("文件的名"+f.getName());
        System.out.println("是否是文件"+f.isFile());
        System.out.println("是否是目录"+f.isDirectory());
        System.out.println(f.getFreeSpace());
        String[] list = f.list();//文件对应的名字数组
        for (String file:list){
            System.out.println(file);
        }
        File[] file=f.listFiles();//作用范文更广泛
        for(File e:file){
            System.out.println("文件名字是"+e.getName()+"文件绝对路径是"+e.getAbsolutePath());
        }
    }
}
