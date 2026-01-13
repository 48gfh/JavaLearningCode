package com.chapter02;

import java.sql.*;
import java.util.Scanner;

public class TestJDBC01 {
    private static String Diver="com.mysql.cj.jdbc.Driver";
    private static String Url = "jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String root="root";
    private static String password="123456";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名");
        String Name = sc.next();
        System.out.println("请输入密码");
        String Password = sc.next();

        Account account=getAccount(Name,Password);
        System.out.println(null!=account?"登录成功":"登录失败");
    }

    private static Account  getAccount(String username,String pwd) {
        Connection connection=null;
        PreparedStatement  preparedStatement= null;
        ResultSet resultSet =null;
        Account account = null;
        try {
            Class.forName(Diver);
            connection =DriverManager.getConnection(Url,root,password);
            /**
             * 使用PreparedStatement语句对象防止注入攻击
             * */
            String sql="select * from account where username = ? and password =? ";
            preparedStatement= connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,pwd);
            resultSet= preparedStatement.executeQuery();//不足要传入sql语句
            while (resultSet.next()){
                int aid = resultSet.getInt("aid");
                String usernamea = resultSet.getString("username");
                String passworda = resultSet.getString("password");
                int money = resultSet.getInt("money");
                account= new Account(aid,usernamea,passworda,money);

            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            assert resultSet != null;
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return account;
    }
}
