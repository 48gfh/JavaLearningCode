package com.UDPProgram.UDP3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 正常通信  发送端  <--> 接收端
 * 发送方DataProgrameSocket 发送数据包 DatagramePacket
 * */

public class TestServers {
    public static void main(String[] args) throws IOException {
        System.out.println("接收端上线");
        DatagramSocket datagramSocket=null;
        DatagramPacket datagramPacket=null;
        DatagramPacket datagramPacket1=null;
        datagramSocket=new DatagramSocket(4323);

        while (true){
            //创建字节套 指定接收方的端口

            //创建一个空数据包 以便于填充数据
            byte[] bytes = new byte[1024];
             datagramPacket=new DatagramPacket(bytes, bytes.length);
            datagramSocket.receive(datagramPacket);
            //将数据取出
            byte[] data =datagramPacket.getData();
            String s = new String(data,0, datagramPacket.getLength());
            System.out.println("------------发送端发送的数据是------------"+s);

            //接收端向发送端发送消息
            System.out.println("------------发送端发送的数据是------------");
            String str1="接收端收到发送端通信，接收端正常返回";
            byte[] bytes1=str1.getBytes();
            //封装数据并指定接收端的端口号
             datagramPacket1 = new DatagramPacket(bytes1, bytes1.length, InetAddress.getByName("localhost"),5463);
            datagramSocket.send(datagramPacket1);
            System.out.println("接收端数据已经发送");
        }

        //关闭


    }
}
