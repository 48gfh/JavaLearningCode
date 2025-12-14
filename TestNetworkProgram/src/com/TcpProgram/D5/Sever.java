package com.TcpProgram.D5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
    public static void main(String[] args) throws IOException {
        //创建字节套指定端口服务器
        Socket s =null;
        System.out.println("服务器已经启动");
        ServerSocket serverSocket = new ServerSocket(2323);
        while (true){
            s = serverSocket.accept();
            new ServerThread(s).start();
        }

    }
}
