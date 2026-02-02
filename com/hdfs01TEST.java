package com;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.Date;

public class hdfs01TEST {

    public static FileSystem fs = null;
    public static void main(String[] args) throws IOException, InterruptedException {
        Configuration configuration = new Configuration(true);
        //创建FileSystem对象
        fs =FileSystem.get(URI.create("hdfs://192.168.10.111:8020"),configuration,"hadoop");
        //查看HDFS的文件路径
        lisHDFSFile("/");
        //System.out.println("==============================================================");

        //在HDFS中创建目录
         //mkdirHDFS("/DIR01");
        System.out.println("==============================================================");

        //向HDFS中上传数据
        //writerHDFS("E:\\Code_Repositories\\BigDataLea\\HADuntitled\\src\\main\\resources\\data.txt","/DIR01");
        System.out.println("==============================================================");

        //重命名HDFS文件
        //renameHDFSFile("/DIR01","/newDIR");
        System.out.println("==============================================================");

        //查看文件详细信息
        //getHDFSFilew("/newDIR");
        System.out.println("==============================================================");

        //删除HDFS中的目录或者文件
        deleteFileOrDirFromHDFS("/newDIR");
        System.out.println("=====================================");
    }

    private static void deleteFileOrDirFromHDFS(String s) throws IOException {
        Path path = new Path("s");
        if (fs.exists(path)) {
            System.out.println("HDFS目录或者文件不存在");
        }
        boolean result = fs.delete(path, true);
        if(result){
            System.out.println("HDFS目录或者文件 "+path+" 删除成功");
        } else {
            System.out.println("HDFS目录或者文件 "+path+" 删除成功");
        }
    }

    private static void getHDFSFilew(String s) throws IOException {
        Path path = new Path(s);
        // 首先检查路径是否存在
        if (!fs.exists(path)) {
            System.out.println("路径不存在: " + s);
            return;
        }

        FileStatus fileStatus = fs.getFileStatus(path);

        // 如果是单个文件，则直接显示该文件的信息
        if (fileStatus.isFile()) {
            System.out.println("文件信息如下:");
            System.out.println("文件路径: " + path.toString());
            System.out.println("文件权限: " + fileStatus.getPermission());
            System.out.println("文件块大小: " + fileStatus.getBlockSize());
            System.out.println("文件长度: " + fileStatus.getLen());
            System.out.println("副本数: " + fileStatus.getReplication());
            System.out.println("修改时间: " + new Date(fileStatus.getModificationTime()));
        } else if (fileStatus.isDirectory()) {
            // 如果是目录，则列出目录下所有文件的信息
            RemoteIterator<LocatedFileStatus> locatedFileStatusRemoteIterator = fs.listFiles(path, true);
            while (locatedFileStatusRemoteIterator.hasNext()) {
                LocatedFileStatus fileSTATUS = locatedFileStatusRemoteIterator.next();
                System.out.println("文件信息如下:");
                System.out.println("文件路径: " + fileSTATUS.getPath());
                System.out.println("文件权限: " + fileSTATUS.getPermission());
                System.out.println("文件块地址: " + fileSTATUS.getBlockLocations());
                System.out.println("文件块大小: " + fileSTATUS.getBlockSize());
                System.out.println("文件长度: " + fileSTATUS.getLen());
                System.out.println("副本数: " + fileSTATUS.getReplication());
                System.out.println("修改时间: " + new Date(fileSTATUS.getModificationTime()));
                System.out.println("----------------------------------------");
            }
        } else {
            System.out.println("路径既不是文件也不是目录: " + s);
        }
    }

    private static void renameHDFSFile(String s, String s2) throws IOException {
        Path path = new Path(s);
        Path path1 = new Path(s2);
        if (fs.rename(path, path1)) {
            System.out.println("更名成功");
        }else {
            System.out.println("更名失败");
        }
    }

    private static void writerHDFS(String s, String s1) throws IOException {
        //判断HDFS中文件是否存在
        Path path = new Path(s1);
        if (fs.exists(path)) {
            System.out.println(fs.delete(path, true));
        }
        //创建HDFS文件路径
        Path path2 = new Path(s1);
        FSDataOutputStream out = fs.create(path2);
        //将本地文件读写入HDFS中
        FileReader fileReader = new FileReader(s);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String newLine="";
        while ((newLine= bufferedReader.readLine())!=null){
            out.write(newLine.getBytes());
            out.write("\n".getBytes());
        }
        out.close();
        bufferedReader.close();
        fileReader.close();

    }

    private static void mkdirHDFS(String s) throws IOException {
        Path path = new Path(s);
        //判断目录是否存在
        if(fs.exists(path)){
            System.out.println(path+"该目录已经存在");
        }else {
            //创建目录
            boolean mkdirs = fs.mkdirs(path);
            if (mkdirs){
                System.out.println(path+"创建成功");
            }else{
                System.out.println(path);
            }
        }


    }


    private static void lisHDFSFile(String s) throws IOException {
        FileStatus[] fileStatuses = fs.listStatus(new Path(s));
        for (FileStatus fileStatus : fileStatuses) {
            System.out.println(fileStatus);
        }
    }
}
