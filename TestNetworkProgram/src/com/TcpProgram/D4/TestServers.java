package com.TcpProgram.D4;

import java.io.*;
import java.net.*;
/**
 *服务端
 * */
public class TestServers {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建套接字节 指定服务器端口
        ServerSocket Socket = new ServerSocket(7897);
        //等待客户端发消息
        Socket socket=Socket.accept();
        //创建输入流接受客户端传入的数据
        InputStream inputData = socket.getInputStream();
        ObjectInputStream objectInputData=new ObjectInputStream(inputData);
        User user= (User) objectInputData.readObject();
        System.out.println("用户的姓名"+user.getName()+"用户的密码是"+user.getPassword());


        //实现逻辑 对客户端输入的用户姓名和密码进行判断
        boolean flag =false;
        if((user.getName()=="lili")&&(user.getPassword()=="123456")){
            flag=true;
        }
        //向客户端返回对比结果
        OutputStream outputStreamData = socket.getOutputStream();
        ObjectOutputStream objectOutputStreamData = new ObjectOutputStream(outputStreamData);
        objectOutputStreamData.writeBoolean(flag);
        objectOutputStreamData.flush();


        //关闭流
        objectInputData.close();
        objectOutputStreamData.close();

    }
}
