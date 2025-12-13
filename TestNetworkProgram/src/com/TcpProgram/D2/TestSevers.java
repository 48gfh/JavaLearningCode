package com.TcpProgram.D2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 实现单线程通信 客户端发送到服务器
 * */

public class TestSevers {
    public static void main(String[] args) throws IOException {
        //创建套字 指定服务器的端口号  服务器只需要指定端口号即可
        ServerSocket socketServers = new ServerSocket(9929);
        /**
         * 等待客户端发来信息
         * accept()方法 该方法是阻塞方法只有接收到客户端传来的数据后才会继续执行
         * 接收到客户端传来的Socket以后客户端和服务端才算建立通信
         * */
        Socket S =socketServers.accept();
        //使用操作
        InputStream inputStreamServers =S.getInputStream();
        DataInputStream dataInputStreamServers = new DataInputStream(inputStreamServers);
        //读取客户端传来的数据
        String str = dataInputStreamServers.readUTF(dataInputStreamServers);
        System.out.println("客户端发送的数据是"+str);
        //关闭流
        dataInputStreamServers.close();

    }
}
