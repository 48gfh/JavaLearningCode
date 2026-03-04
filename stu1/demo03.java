package com.stu1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * HBase JavaAPI
 * */
public class demo03 {
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
        createTable("myspace","t1","cf1","cf2");
        //向表中插入数据
        insertData("myspace","t1","rk1","cf1","name","zs");
        insertData("myspace","t1","rk1","cf1","name","zs");
        insertData("myspace","t1","rk1","cf1","age","18");
        insertData("myspace","t1","rk2","cf1","name","ls");
        insertData("myspace","t1","rk2","cf1","age","19");
        insertData("myspace","t1","rk3","cf1","name","ww");
        insertData("myspace","t1","rk3","cf1","age","20");
        getDataByRowKey("myspace","t1","rk1");
        scanTableData("myspace","t1","rk1","rk3");
        deleteTableData("myspace","t1","rk3","cf1","name");
        truncateTableData("myspace","t1");
    }
    //清空表 清空表之前需要将表禁用
    private static void truncateTableData(String myspace, String t1) throws IOException {
        Admin admin = conn.getAdmin();
        //禁用表
        TableName tableName = TableName.valueOf(myspace, t1);
        admin.disableTable(tableName);
        admin.truncateTable(tableName,true);
        admin.close();
        System.out.println("清空完成");
        admin.close();
    }

    //据rowkey删除数据可以指定删除列族下某个列的数据，也可以将指定列族删除或者将表中所有列族数据删除。
    private static void deleteTableData(String myspace, String t1, String rowKey, String cf , String col) throws IOException {
        Table table = conn.getTable(TableName.valueOf(myspace, t1));
        //创建Delete对象
        Delete delete = new Delete(Bytes.toBytes(rowKey));
        //删除整个列族
        delete.addFamily(Bytes.toBytes(cf));
        table.delete(delete);
        System.out.println("删除rowkey数据完成");
    }

    //扫描整张表
    private static void scanTableData(String myspace, String t1, String startrk1, String stoprk3) throws IOException {
        Table table = conn.getTable(TableName.valueOf(myspace, t1));
        //创建scan扫描整张表
        Scan scan = new Scan();
        //设置扫描rk 默认范围[startrk1,stoprk2),也可以设置不到扫描全表数据
        scan.withStartRow(Bytes.toBytes(startrk1));
        scan.withStopRow(Bytes.toBytes(stoprk3));
        // scan.withStopRow(Bytes.toBytes(endRow),true); //第二个参数设置为true,表示包含endRow
        ResultScanner scanner = table.getScanner(scan);
        //总行数
        long rowCnt=0L;
        //每个result都是一行数据
        for (Result result : scanner) {
            //获取结果数据
            Cell[] cells = result.rawCells();
            rowCnt++;
            //打印数据
            for (Cell cell : cells) {
                System.out.println("RowKey: " + Bytes.toString(CellUtil.cloneRow(cell)));
                System.out.println("Column Family: " + Bytes.toString(CellUtil.cloneFamily(cell)));
                System.out.println("Column Qualifier: " + Bytes.toString(CellUtil.cloneQualifier(cell)));
                System.out.println("Value: " + Bytes.toString(CellUtil.cloneValue(cell)));
                System.out.println("------------------------------");
            }
            System.out.println("表"+t1+"共扫描数据"+rowCnt+"行");
            table.close();
        }
    }

    //以rowkey为依据查数据
    private static void getDataByRowKey(String myspace, String t1, String rk2) throws IOException {
        Table table = conn.getTable(TableName.valueOf(myspace, t1));
        Get get = new Get(Bytes.toBytes(rk2));
        get.readVersions(1);//设置读取的版本
        Result result = table.get(get);
        //获取结果数据
        Cell[] cells = result.rawCells();
        for (Cell cell : cells) {
            System.out.println("Rowkey"+Bytes.toString(CellUtil.cloneRow(cell)));
            System.out.println("Column Family"+Bytes.toString(CellUtil.cloneFamily(cell)));
            System.out.println("Column Qualifer"+Bytes.toString(CellUtil.cloneQualifier(cell)));
            System.out.println("Value"+Bytes.toString(CellUtil.cloneValue(cell)));
            System.out.println("---------------------------------------------------");
        }
        table.close();
    }

    private static void insertData(String myspace, String tb, String rk, String cf, String col, String value) throws IOException {
        TableName tableName = TableName.valueOf(myspace, tb);
        //获取表
        Table table = conn.getTable(tableName);
        //创建put对象
        Put put = new Put(Bytes.toBytes(rk));
        put.addColumn(Bytes.toBytes(cf),Bytes.toBytes(col),Bytes.toBytes(value));
        //将put对象写入table中
        table.put(put);
        System.out.println("数据插入完成");
        table.close();
    }

    private static void createTable(String myspace, String t1, String ... cf2) throws IOException {
        Admin admin = conn.getAdmin();
        if (cf2.length==0) {
            System.out.println("至少需要传入一个列族！！！！");
            return;
        }
        //将字符串表名转为TableName对象
        TableName tableName = TableName.valueOf(myspace, t1);
        if (admin.tableExists(tableName)) {
            System.out.println("该数据库中已经有此表，无需再次创建");
            return;
        }
        //创建表描述器
        TableDescriptorBuilder tableDescriptorBuilder = TableDescriptorBuilder.newBuilder(tableName);
        //设置列族信息
        for (String s : cf2) {
            ColumnFamilyDescriptorBuilder columnFamilyDescriptorBuilder = ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes(s));
            //将列族信息添加到表描述器对象
            tableDescriptorBuilder.setColumnFamily(columnFamilyDescriptorBuilder.build());
        }
        //创建表
        admin.createTable(tableDescriptorBuilder.build());
        System.out.println(t1+"创建成功");
    }
}
