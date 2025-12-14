package com.UDPProgram.UDP2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 双向通信  发送端  <--> 接收端
 * 发送方DataProgrameSocket 发送数据包 DatagramePacket
 * */
public class TestClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送端上线");
        //准备套字节 指定发送方端口
        DatagramSocket ds = new DatagramSocket(5463);
        //准备数据包
        String str="hello";
        byte[] bytes =str.getBytes();
        /**
         * 需要的四个参数
         * 1 将传送数据转为字节数
         * 2 字节数组的长度
         * 3 封装接受方的IP
         * 4 指定接收方的端口号码
         * */
        DatagramPacket datagramSocket = new DatagramPacket(bytes,bytes.length,InetAddress.getByName("localhost"),4323);
        //发送
        ds.send(datagramSocket);
        System.out.println("发送成功");

        //接收端 --> 发送端
        byte[] bytes1 =new byte[1024];
        DatagramPacket datagramPacket1 =new DatagramPacket(bytes1, bytes1.length);
        ds.receive(datagramPacket1);
        String str1 = new String(bytes1,0, datagramPacket1.getLength());
        System.out.println("接收端发送的数据是"+str1);

        //关闭
        ds.close();
    }
}
