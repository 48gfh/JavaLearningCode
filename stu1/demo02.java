package com.stu1;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * HBase JavaAPI DDL操作
 * */
public class demo02 {
    //静态块准备连接HBase的Connection的对象
    private static Connection conn=null;
    static {
        //创建配置文件对象
        Configuration conf = HBaseConfiguration.create();
        //加载Zookeeper的配置
        conf.set("hbase.zookeeper.quorum","hadoop111,hadoop112,hadoop113");
        //获取连接
        try {
            conn= ConnectionFactory.createConnection(conf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws IOException {
        //判断表是否存在
        existTable("ns","tb1");

        //创建表
        createTabele("ns","tb1","cf1","cf2");

        //查看所有表
        getHBaseTable();

        //给表添加新的列族
        addColumnFamily("ns","tb1","cf3");

        //修改表Version个数
        modifyColumnFamilyVersion("ns","tb1","cf1",3);

        //删除表API
        deleteTable("ns","tb1");

    }

    //删除表
    private static void deleteTable(String ns, String tb1) throws IOException {
        Admin admin = conn.getAdmin();
        //将字符串表名转换成TableName对象
        TableName tableName = TableName.valueOf(ns,tb1);
        if (existTable(ns, tb1)) {
            //删除表
            admin.disableTable(tableName); //删除之前需要先禁用这个表
            admin.deleteTable(tableName);
        }
    }

    private static void modifyColumnFamilyVersion(String ns, String tb1, String cf3, int i) throws IOException {
        Admin admin = conn.getAdmin();
        //将字符串表名转为TableName对象
        TableName tableName = TableName.valueOf(ns,tb1);
        //获取表描述器
        TableDescriptor tableDescriptor = admin.getDescriptor(tableName);
        //检查列族是否已经存在
        if (tableDescriptor.hasColumnFamily(cf3.getBytes())) {
            System.out.println("表"+tb1+"中列族"+cf3+"不存在，无法修改还");

        }
        //基于表描述器，获取列族描述器
        ColumnFamilyDescriptor familyDescriptors = tableDescriptor.getColumnFamily(cf3.getBytes());
        //修改列族的版本数
        familyDescriptors=ColumnFamilyDescriptorBuilder.newBuilder(familyDescriptors).setMaxVersions(i).build();
        //修改列族描述符
        tableDescriptor=TableDescriptorBuilder.newBuilder(tableDescriptor).modifyColumnFamily(familyDescriptors).build();

        admin.modifyTable(tableDescriptor);
        System.out.println("表"+tb1+"的列族"+cf3+"版本号"+i+"已经修改成功");
        admin.close();

    }

    //给表添加新的列族方法
    private static void addColumnFamily(String ns, String tb1, String cf3) throws IOException {
        Admin admin = conn.getAdmin();
        //将字符串类型的表名转为TableName对象
        TableName tableName = TableName.valueOf(ns,tb1);
        //获取表描述器
        TableDescriptor tableDescriptor = admin.getDescriptor(tableName);
        //检查列族是否存在
        if (tableDescriptor.hasColumnFamily(cf3.getBytes())) {
            System.out.println("表"+tb1+"中列族"+cf3+"已经存在，无法添加");
            return;
        }

        //创建列族描述符
        ColumnFamilyDescriptor familyDescriptor = ColumnFamilyDescriptorBuilder.newBuilder(cf3.getBytes()) .
                setMaxVersions(1)
               .build();
        //添加列族到表描述
        tableDescriptor = TableDescriptorBuilder.newBuilder(tableDescriptor)
                .setColumnFamily(familyDescriptor)
                .build();
        //修改表描述符
        admin.modifyTable(tableDescriptor);
        System.out.println("给表"+tb1+"添加列族"+"cf3"+"成功");
        admin.close();
    }

    //查看HBase中所有表
    private static void getHBaseTable() throws IOException {
        Admin admin = conn.getAdmin();
        TableName[] tableNames = admin.listTableNames();
        for (TableName tableName : tableNames) {
            System.out.println(tableName.toString());
        }
    }

    //创建表API
    private static void createTabele(String myspace, String tb1, String ... cfs) throws IOException {
        Admin admin = conn.getAdmin();
        if (cfs.length==0) {
            System.out.println("至少需要一个列族");
            return;
        }
        //将字符串类型的表名转为TableName对象（带命名空间）
        TableName tableName = TableName.valueOf(myspace, tb1);
        if (existTable(myspace,tb1)) {
            System.out.println(myspace+"已经存在"+tb1+"已经存在");
            return;
        }
        //创建表描述器
        TableDescriptorBuilder tableDescriptorBuilder = TableDescriptorBuilder.newBuilder(tableName);
        //设置列族信息
        for (String cf : cfs) {
            //准备列族描述器
            ColumnFamilyDescriptorBuilder columnFamilyDescriptorBuilder = ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes(cf));
            //将列族信息添加到表描述器对象
            tableDescriptorBuilder.setColumnFamily(columnFamilyDescriptorBuilder.build());
        }
        //创建表
        admin.createTable(tableDescriptorBuilder.build());
        System.out.println("创建"+tb1+"成功");
    }

    //判断表是否存在
    private static boolean existTable(String ns, String tb1) throws IOException {

        Admin admin = conn.getAdmin();
        //将String类型tableName转为TableName类的对象
        TableName tableName = TableName.valueOf(ns, tb1);
        //判断表是否存在
        boolean tableExists = admin.tableExists(tableName);
        if (tableExists) {
            System.out.println("该表已经存在");
        }else {
            System.out.println("该表不存在");
        }
        admin.close();
        return tableExists;
    }
}
