package com.TcpProgram.D5;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

//客户端
public class TestClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建字节套 指定服务器ip 和端口
        Socket socket=new Socket("127.0.0.1",2323);
        //录入账号和密码
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户姓名");
        String nameUser = scanner.next();
        System.out.println("请输入用户密码");
        String passwordUser = scanner.next();
        //对录入的数据进行封装
        User user= new User(nameUser,passwordUser);
        //利用输出流向外发送数据
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(user);


        //接受服务端返回的数据
        InputStream inputStream =socket.getInputStream();
        DataInputStream dataInput = new DataInputStream(inputStream);
        boolean flag= dataInput.readBoolean();
        if(flag){
            System.out.println("验证成功");
        }else {
            System.out.println("验证失败");
        }

        //关闭流
        objectOutputStream.close();
        dataInput.close();

    }
}
