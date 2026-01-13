package com.chapter03;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用PrepareStatement完成CRUD
 * */
public class TestJDBC01 {
    private static String Diver="com.mysql.cj.jdbc.Driver";
    private static String Url = "jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String root="root";
    private static String password="123456";
    public static void main(String[] args) {
        testAdd();
        testUpdate();
        testDelete();
        testQuery();

    }

    private static void testQuery() {
        //查询表中包含字母A的员工信息
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        List<Emp> list=null;

        try {
            connection=DriverManager.getConnection(Url,root,password);
            String sql = "select * from emp  where ename like ?";
            preparedStatement= connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setString(1,"%A%");
            //执行
            resultSet= preparedStatement.executeQuery();
            list=new ArrayList<Emp>();

            while (resultSet.next()){
                int empno = resultSet.getInt("empno");
                String ename = resultSet.getString("ename");
                String job = resultSet.getString("job");
                int mgr = resultSet.getInt("mgr");
                Date hiredate = resultSet.getDate("hiredate");
                double sal= resultSet.getDouble("sal");
                double comm= resultSet.getDouble("comm");
                int deptno= resultSet.getInt("deptno");
                Emp emp =new Emp(empno, deptno, comm, sal, hiredate, mgr, job, ename);
                list.add(emp);
            }
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
            for (Emp emp : list) {
                System.out.println(emp);
            }
        }
    }

    private static void testDelete() {
        //根据员工号删除员工表中的数据
        Connection connection = null;
        PreparedStatement preparedStatement= null;

        try {
            Class.forName(Diver);
            connection= DriverManager.getConnection(Url,root,password);
            String sql = "delete  from emp where empno=?";
            preparedStatement= connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setInt(1,7936);
            int rows = preparedStatement.executeUpdate();
            System.out.println("影响行数"+rows);


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

    }

    private static void testUpdate() {
        //依据工号修改员工数据
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(Diver);
            connection=DriverManager.getConnection(Url,root,password);
            String sql = "update emp set ename=?,job=? where empno=?";
            preparedStatement= connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setString(1,"WangWu");
            preparedStatement.setString(2,"SALESMAN");
            preparedStatement.setInt(3,7876);
            int rows = preparedStatement.executeUpdate();
            System.out.println("影响行数"+rows);

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
    }

    private static void testAdd() {
        //向emp表中增加数据
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(Diver);
            connection= DriverManager.getConnection(Url,root,password);
            String sql = "insert into emp values (default ,?,?,?,?,?,?,?)";
            preparedStatement= connection.prepareStatement(sql); //在这里sql语句已经传入
            //设置参数
            preparedStatement.setString(1,"mark");
            preparedStatement.setString(2,"manager");
            preparedStatement.setString(3,"7839");
            preparedStatement.setDate(4, new Date(System.currentTimeMillis()));
            preparedStatement.setDouble(5,4000.89);
            preparedStatement.setDouble(6,0.0);
            preparedStatement.setDouble(6,0.0);
            preparedStatement.setDouble(7,30);
            //执行CRUD
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows);

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
    }
}

