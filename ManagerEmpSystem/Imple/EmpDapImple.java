package com.ManagerEmpSystem.Imple;

import com.ManagerEmpSystem.pojo.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpDapImple implements  EmpDao{
    private static String Diver="com.mysql.cj.jdbc.Driver";
    private static String Url = "jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
    private static String root="root";
    private static String password="123456";
    @Override
    public int addEmp(Emp emp) {
        int rows=0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(Diver);
            connection=DriverManager.getConnection(Url,root,password);
            String sql = "insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) values (?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement= connection.prepareStatement(sql);

            preparedStatement.setObject(1,emp.getEmpno());      // empno (整数类型)
            preparedStatement.setObject(2,emp.getEname());      // ename
            preparedStatement.setObject(3,emp.getJob());        // job
            preparedStatement.setObject(4,emp.getMgr());        // mgr
            preparedStatement.setObject(5,emp.getHiredate());   // hiredate
            preparedStatement.setObject(6,emp.getSal());        // sal
            preparedStatement.setObject(7,emp.getComm());       // comm
            preparedStatement.setObject(8,emp.getDeptno());
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
    public int deleteEmp(int empno) {
        int rows= 0;
        Connection connection = null;
        PreparedStatement preparedStatement =null;

        try {
            Class.forName(Diver);
            connection = DriverManager.getConnection(Url,root,password);
            String sql ="delete from emp where empno=?;";
            preparedStatement= connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setObject(1,empno);
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
        return rows;
    }

    @Override
    public List<Emp> findALL() {
        Connection connection= null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Emp> list= new ArrayList<>();

        try {
            Class.forName(Diver);
            connection= DriverManager.getConnection(Url,root,password);
            String sql = "select * from emp;";
            preparedStatement= connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                int empno= resultSet.getInt("empno");
                String ename= resultSet.getNString("ename");
                String job= resultSet.getNString("job");
                int mgr = resultSet.getInt("mgr");
                Date hiredate=resultSet.getDate("hiredate");
                double sal = resultSet.getDouble("sal");
                double comm = resultSet.getDouble("comm");
                int deptno = resultSet.getInt("deptno");
                Emp emp = new Emp(empno,ename,job,mgr,hiredate,sal,comm,deptno);
                list.add(emp);


            }
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


        return list;
    }

    @Override
    public int updateEmp(Emp emp) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        int rows =0;

        try {
            Class.forName(Diver);
            connection= DriverManager.getConnection(Url,root,password);
            String sql = "update emp set ename =? ,job=?, mgr =?,hiredate =?,sal=?,comm=?,deptno=? where empno =?";
            preparedStatement= connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setObject(1,emp.getEname());      // ename
            preparedStatement.setObject(2,emp.getJob());        // jop (注意：这里应该对应数据库中的字段名)
            preparedStatement.setObject(3,emp.getMgr());        // mgr
            preparedStatement.setObject(4,emp.getHiredate());   // hiredate
            preparedStatement.setObject(5,emp.getSal());        // sal
            preparedStatement.setObject(6,emp.getComm());       // comm
            preparedStatement.setObject(7,emp.getDeptno());     // deptno
            preparedStatement.setObject(8,emp.getEmpno());      // where empno=?

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
