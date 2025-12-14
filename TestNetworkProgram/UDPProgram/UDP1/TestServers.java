package com.UDPProgram.UDP1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class TestServers {
    public static void main(String[] args) throws IOException {
        System.out.println("接收端上线");
        //创建字节套 指定接收方的端口
        DatagramSocket datagramSocket=new DatagramSocket(4323);
        //创建一个空数据包 以便于填充数据
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket=new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(datagramPacket);
        //将数据取出
        byte[] data =datagramPacket.getData();
        String s = new String(data,0, datagramPacket.getLength());
        System.out.println("发送端发送的数据是"+s);

        //关闭
        datagramSocket.close();
    }
}
