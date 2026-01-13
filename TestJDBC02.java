package com.chapter03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * PreparedStatement批处理
 * */
public class TestJDBC02 {
    private static String Diver="com.mysql.cj.jdbc.Driver";
    private static String Url = "jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String root="root";
    private static String password="123456";

    public static void main(String[] args) {
        testAddBatch();
    }

    private static void testAddBatch() {
        Connection connection =null;
        PreparedStatement preparedStatement =null;

        try {
            Class.forName(Diver);
            connection= DriverManager.getConnection(Url,root,password);
            String sql = "insert into dept values (default,?,?)";
            preparedStatement= connection.prepareStatement(sql);
            for (int i = 0; i < 30; i++) {
                preparedStatement.setString(1, "name");
                preparedStatement.setString(2, "loc");
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            preparedStatement.clearBatch();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        }
    }
}
