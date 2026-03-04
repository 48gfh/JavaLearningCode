package com.stu1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

/**
 * JavaAPI NameSpace操作
 * */
public class demo01 {
    private static Connection conn=null;
    //静态块准备连接HBase的Connection对象
    static {
        //创建配置文件对象
        Configuration conf = HBaseConfiguration.create();
        //加载Zookeeper配置
        conf.set("hbase.zookeeper.quorum","hadoop111,hadoop112,hadoop113");
        //获取连接
        try {
          conn = ConnectionFactory.createConnection(conf);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws IOException {
        createNameSpace("ns");
        getHBaseADDNS();
        deleteNameSpaces("ns");

    }

    //产出HBase中的命名空间
    private static void deleteNameSpaces(String ns) throws IOException {
        Admin admin = conn.getAdmin();
        admin.deleteNamespace(ns);
        System.out.println("删除"+ns+"成功");
    }

    // 查看HBase中所有的NameSpace
    private static void getHBaseADDNS() throws IOException {
        Admin admin = conn.getAdmin();
        String[] all =admin.listNamespaces();
        for (int i = 0; i < all.length; i++) {
            System.out.println(all[i]);
        }
        System.out.println("打印HBase中所有的NameSpace");
        admin.close();
    }

    //创建NameSpace API操作
    private static void createNameSpace(String ns) throws IOException {

        Admin admin = conn.getAdmin();
        //创建命名空间的描述器对象
        NamespaceDescriptor namespaceDescriptor = NamespaceDescriptor.create(ns).build();
        //创建命名空间
        admin.createNamespace(namespaceDescriptor);
        System.out.println("创建"+ns+"命名空间完成");
        admin.close();
    }
}
