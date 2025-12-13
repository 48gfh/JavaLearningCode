package com.TcpProgram.D3;

import java.io.*;
import java.net.Socket;

/**
 * 实现双向通信 客户端发送到服务器
 * */
public class TestClient {
    public static void main(String[] args) throws IOException {
        //创建套接字 指定服务器的ip地址和端口号
        Socket socket = new Socket("127.0.0.1",9929);
        //TCP向外发送数据  利用输出流发送数据
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("hbfudisofgduios");

        //接受服务段回话
        InputStream inputStreamdata = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStreamdata);
        String str=dataInputStream.readUTF();
        System.out.println("服务端回文"+str);

        //关闭流
        dataOutputStream.close();
        dataInputStream.close();
    }
}
