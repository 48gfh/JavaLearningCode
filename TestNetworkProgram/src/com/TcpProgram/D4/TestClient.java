package com.TcpProgram.D4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 对象流传送  客户端
 * */
public class TestClient {
    public static void main(String[] args) throws IOException {
        //创建套接字节 指定服务器ip 和端口
        Socket socket= new Socket("127.0.0.1",7897);
        //录入用户的账号和密码
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户姓名");
        String nameUser = scanner.next();
        System.out.println("请输入用户密码");
        String passwordUser = scanner.next();
        //对用户输入的数据进行封装
        User user = new User(nameUser,passwordUser);

        //利用输出流向外发送数据
        OutputStream outputData = socket.getOutputStream();
        ObjectOutputStream objectOutputStreamData = new ObjectOutputStream(outputData);
        objectOutputStreamData.writeObject(user);
        System.out.println("传输成功");

        //接受服务端返回数据
        InputStream inputStreamData =socket.getInputStream();
        ObjectInputStream objectInputStreamData = new ObjectInputStream(inputStreamData);
        boolean flag= objectInputStreamData.readBoolean();
        if(flag){
            System.out.println("验证成功");
        }else {
            System.out.println("验证失败");
        }

        //关闭
        objectOutputStreamData.close();
        objectInputStreamData.close();

    }
}
