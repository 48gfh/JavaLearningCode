package com.TcpProgram.D1;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * InetAddress 对IP地址进行封装
 *
 * */
public class test01 {
    public static void main(String[] args) throws UnknownHostException {
        //封装IP
        InetAddress ia = InetAddress.getByName("127.0.0.1");
        System.out.println(ia);
        InetAddress ia2 =InetAddress.getByName("localhost");
        System.out.println(ia2);
        //获取本计算机的名字
        InetAddress ia3 =InetAddress.getLocalHost();
        System.out.println(ia3);
        //封装计算机名
        InetAddress ia4  = InetAddress.getByName("DESKTOP-CHU0F48");
        System.out.println(ia4);
        //封装域名
        InetAddress ia5 = InetAddress.getByName("www.baidu.com");
        System.out.println("域名是"+ia5.getHostName());
        System.out.println("IP地址是"+ia5.getHostAddress());

    }
}
