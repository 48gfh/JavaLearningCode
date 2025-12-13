package com.TcpProgram.D1;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * InetSocketAddress 对IP地址和端口进行封装
 * */
public class test02 {
    public static void main(String[] args) throws UnknownHostException {
        InetSocketAddress isa = new InetSocketAddress("127.0.0.1",6066);
        System.out.println(isa);
        System.out.println(isa.getAddress());
        System.out.println(isa.getHostName());
        System.out.println(isa.getPort());
        InetAddress ia = InetAddress.getByName("127.0.0.1");
        System.out.println(ia.getHostName());
        System.out.println(ia.getHostAddress());
    }
}
