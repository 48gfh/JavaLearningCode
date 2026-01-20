package com.ManagerEmpSystem.Imple;

import com.ManagerEmpSystem.pojo.Dept;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class DeptDaoImple extends BaseDAO implements  DeptDao {
    private static String Diver="com.mysql.cj.jdbc.Driver";
    private static String Url = "jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
    private static String root="root";
    private static String password="123456";
    @Override
    public List<Dept> findAll() {
      /*  Connection connection =null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        List<Dept> list = new ArrayList<>();

        try {
            Class.forName(Diver);
            connection= DriverManager.getConnection(Url,root,password);
            String sql ="select  * from dept;";
            preparedStatement= connection.prepareStatement(sql);
            resultSet= preparedStatement.executeQuery();

            while (resultSet.next()){
                int deptno= resultSet.getInt("deptno");
                String dname= resultSet.getNString("dname");
                String loc = resultSet.getNString("loc");
                Dept dept = new Dept(deptno,dname,loc);
                list.add(dept);
            }

        } catch (SQLException | ClassNotFoundException e) {
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
        return list;*/
        String sql="select * from dept";
        return  baseQuery(Dept.class, sql);
    }

    @Override
    public int addDept(Dept dept) {
        /*int rows=0;
        Connection connection=null;
        PreparedStatement preparedStatement=null;

        try {
            Class.forName(Diver);
            connection=DriverManager.getConnection(Url,root,password);
            String sql ="insert into dept values(?,?,?)";
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setObject(1,dept.getDeptno());
            preparedStatement.setObject(2,dept.getDname());
            preparedStatement.setObject(3,dept.getLoc());
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
        return rows;*/

        //使用BaseDAO优化后
        String sql = "insert into dept values (?,?,?)";

        return baseUpdate(sql,dept.getDeptno(),dept.getDname(),dept.getLoc());

    }
}
