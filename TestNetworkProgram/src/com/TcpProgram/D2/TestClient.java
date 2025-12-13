package com.TcpProgram.D2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 实现单线程通信 客户端发送到服务器
 * */
public class TestClient {
    public static void main(String[] args) throws IOException {
        //创建套接字 指定服务器的ip地址和端口号
        Socket socket = new Socket("127.0.0.1",9929);
        //TCP向外发送数据  利用输出流发送数据
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("hbfudisofgduios");
        //关闭流
        dataOutputStream.close();
    }
}
