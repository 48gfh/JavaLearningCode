package com.ManagerEmpSystem.Imple;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO {
    private static String Diver="com.mysql.cj.jdbc.Driver";
    private static String Url = "jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
    private static String root="root";
    private static String password="123456";

    //利用反射机制实现对查询的操作
    public List  baseQuery (Class clazz,String sql,Object ... args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet= null;
        List list =null;

        try {
            Class.forName(Diver);
            connection=DriverManager.getConnection(Url,root,password);
            preparedStatement= connection.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            resultSet= preparedStatement.executeQuery();
            list= new ArrayList<>();
            //设置所有字段可访问
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
            }
            while (resultSet.next()){
                // 通过反射创建目标类的新实例
                Object obj =clazz.newInstance(); // 调用无参构造函数
                // 为每个字段赋值
                for (Field field : fields) {
                    String fieldName = field.getName();
                    Object data = resultSet.getObject(fieldName);
                    field.set(obj,data);
                }
                list.add(obj);
            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return list;
    }



    //对创、删、改 三个方法中相似的地方进行向上抽取并封装
    public int baseUpdate(String  sql,Object ... args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows=0;

        try {
            Class.forName(Diver);
            connection = DriverManager.getConnection(Url,root,password);
            preparedStatement= connection.prepareStatement(sql);
            //设置参数
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            rows = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (rows>0){
            System.out.println("数据操作成功");
        }else {
            System.out.println("操作失败");
        }
        return rows;
    }
}
