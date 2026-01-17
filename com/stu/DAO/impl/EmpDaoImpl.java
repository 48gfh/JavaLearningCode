package com.stu.DAO.impl;

import com.stu.DAO.pojo.Emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//DAO实现类代码
public class EmpDaoImpl implements EmpDao  {
    private static String Diver="com.mysql.cj.jdbc.Driver";
    private static String Url = "jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String root="root";
    private static String password="123456";

    @Override
    public int addEmp(Emp emp) {
        //向Emp表中增加一条数据
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        int rows=0;

        try {
            Class.forName(Diver);
            connection= DriverManager.getConnection(Url,root,password);
            String sql = "insert into emp values (default,?,?,?,?,?,?,?,) ";
            preparedStatement= connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setObject(1,emp.getEname());
            preparedStatement.setObject(2,emp.getJob());
            preparedStatement.setObject(3,emp.getMgr());
            preparedStatement.setObject(4, emp.getHiredate());
            preparedStatement.setObject(5,emp.getSal());
            preparedStatement.setObject(6,emp.getComm());
            preparedStatement.setObject(7,emp.getEmpno());
            rows= preparedStatement.executeUpdate();


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
        return rows;
    }

    @Override
    public int deleteByEmpno(int empno) {
        //向emp表中增加一条数据
        Connection connection= null;
        PreparedStatement preparedStatement= null;
        int rows = 0;

        try {
            Class.forName(Diver);
            connection= DriverManager.getConnection(Url,root,password);
            String sql ="delete from emop where empno = ?";
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setObject(1,empno);

            rows= preparedStatement.executeUpdate();

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


        return rows;
    }
}
