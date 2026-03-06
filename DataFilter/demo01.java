package com.DataFilter;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;


/**
 * FamilyFilter 可以取回所有符合条件的列族 Fanily,通常用于检索特定列族的数据
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
        //FamilyFilter 查询指定列族所有数据
        //familyFilyer("default","filter_tbl","cf1");
        //columnPrefixFilter("default","filter_tbl","prefixB");
        //multipleColumnPrefixFilter("default","filter_tbl","prefixA_col1","prefixB");
        rowFilter("default","filter_tbl","row3");
    }

    private static void rowFilter(String ns,String tbl,String rk) throws IOException {
        //获取表
        Table table = conn.getTable(TableName.valueOf(ns, tbl));
        //创建scan扫描对象
        Scan scan = new Scan();
        //创建并设置RowFilter
        RowFilter rowFilter = new RowFilter(CompareOperator.GREATER_OR_EQUAL, new BinaryComparator(Bytes.toBytes(rk)));
        scan.setFilter(rowFilter);
        //获取scanner对象，该对象会扫描多行数据
        ResultScanner scanner = table.getScanner(scan);
        //每个result是一行数据
        for (Result result : scanner) {
            Cell[] cells = result.rawCells();
            //打印数据
            for (Cell cell : cells) {

                System.out.println("RowKey"+Bytes.toString(CellUtil.cloneRow(cell)));
                System.out.println("ColumnFamily"+Bytes.toString(CellUtil.cloneFamily(cell)));
                System.out.println("Column Qualifier"+Bytes.toString(CellUtil.cloneQualifier(cell)));
                System.out.println("Value"+Bytes.toString(CellUtil.cloneValue(cell)));
                System.out.println("-------------------------------------------------------------------");

            }
        }
    }

    /**
     * MultipleColumnPrefixFilter：检索列限定符以多个前缀之一开始的数据
     * @param ns
     * @param tbl
     * @param colPrefix1
     * @param colPrefix2
     */
    private static void multipleColumnPrefixFilter(String ns,String tbl,String colPrefix1 ,String colPrefix2) throws IOException {
        Table table = conn.getTable(TableName.valueOf(ns, tbl));
        //创建扫描对象
        Scan scan = new Scan();
        //创建并设置MultipleColumnPrefixFilter
        byte[][] colPrefix={Bytes.toBytes(colPrefix1),Bytes.toBytes(colPrefix2)};
        MultipleColumnPrefixFilter multipleColumnPrefixFilter = new MultipleColumnPrefixFilter(colPrefix);
        scan.setFilter(multipleColumnPrefixFilter);
        //获取scanner对象，该对象会扫描多行数据
        ResultScanner scanner = table.getScanner(scan);
        //每一个result就是一行数据
        for (Result result : scanner) {
            //获取结果数据
            Cell[] cells = result.rawCells();
            //打印数据
            for (Cell cell : cells) {
                System.out.println("RowKey"+Bytes.toString(CellUtil.cloneRow(cell)));
                System.out.println("ColumnFamily"+Bytes.toString(CellUtil.cloneFamily(cell)));
                System.out.println("Column Qualifier"+Bytes.toString(CellUtil.cloneQualifier(cell)));
                System.out.println("Value"+Bytes.toString(CellUtil.cloneValue(cell)));
                System.out.println("-------------------------------------------------------------------");
            }
        }

    }

    /**
     * ColumnPrefixFilter 查询符合列前缀所有数据
     * @param ns
     * @param tbl
     * @param colPrefix
     */
    private static void columnPrefixFilter(String ns,String tbl,String colPrefix) throws IOException {
        //获取表
        Table table = conn.getTable(TableName.valueOf(ns, tbl));
        //创建scan扫描对象
        Scan scan = new Scan();
        //创建并设置ColumnPrefixFilter
        ColumnPrefixFilter columnPrefixFilter = new ColumnPrefixFilter(Bytes.toBytes(colPrefix));
        scan.setFilter(columnPrefixFilter);
        //获取scanner对象，该对象会扫描多行数据
        ResultScanner scanner = table.getScanner(scan);
        //每个result是一行数据
        for (Result result : scanner) {
            //获取结果数据
            Cell[] cells = result.rawCells();
            //打印数据
            for (Cell cell : cells) {
                System.out.println("RowKey"+Bytes.toString(CellUtil.cloneRow(cell)));
                System.out.println("ColumnFamily"+Bytes.toString(CellUtil.cloneFamily(cell)));
                System.out.println("Column Qualifier"+Bytes.toString(CellUtil.cloneQualifier(cell)));
                System.out.println("Value"+Bytes.toString(CellUtil.cloneValue(cell)));
                System.out.println("-------------------------------------------------------------------");;
            }
        }
        table.close();
    }

    /**
     * FamilyFilter 查询指定列族所有数据
     * @param nameSpace  命名空间名称
     * @param tb 表格名称
     * @param rk 主键
     */
    private static void familyFilyer(String nameSpace, String tb, String rk) throws IOException {
        //获取表
        Table table = conn.getTable(TableName.valueOf(nameSpace, tb));
        //创建scan扫描对象
        Scan scan = new Scan();
        //NO_OP 不进行任何操作  EQUAL才是zhenchang
        FamilyFilter cf1= new FamilyFilter(CompareFilter.CompareOp.EQUAL, new BinaryComparator(Bytes.toBytes(rk)));
        scan.setFilter(cf1);
        //获取scanner对象，该对象会扫描多行数据
        ResultScanner scanner = table.getScanner(scan);
        //每一个result是一行数据
        for (Result result : scanner) {
            Cell[] cells = result.rawCells();
            //打印数据
            for (Cell cell : cells) {
                System.out.println("RowKey"+Bytes.toString(CellUtil.cloneRow(cell)));
                System.out.println("ColumnFamily"+Bytes.toString(CellUtil.cloneFamily(cell)));
                System.out.println("Column Qualifier"+Bytes.toString(CellUtil.cloneQualifier(cell)));
                System.out.println("Value"+Bytes.toString(CellUtil.cloneValue(cell)));
                System.out.println("-------------------------------------------------------------------");
            }
        }
        table.close();
    }
}
