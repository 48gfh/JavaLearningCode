import java.sql.*;
import java.util.Date;

public class TestJDBC02 {
    private static String Diver="com.mysql.cj.jdbc.Driver";
    private static String Url = "jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String root="root";
    private static String password="123456";

    public static void main(String[] args) {
        //查询全部员工信息
        testQuery();
        //修改部门信息
        //testUpdate();
        //删除部门信息
       // deletedate();
        
        

    }

    private static void testQuery() {
        try {
            Connection connection=null;
            Statement statement=null;
            ResultSet resultSet=null;
            Class.forName(Diver);
            connection=DriverManager.getConnection(Url,root,password);
            statement= connection.createStatement();
            String sql = "select * from emp;";
            resultSet =statement.executeQuery(sql);


            while (resultSet.next()){
                int empno = resultSet.getInt("empno");
                String ename = resultSet.getString("ename");
                String job = resultSet.getNString("job");
                int mgr = resultSet.getInt("mgr");
                Date hiredate = resultSet.getDate("hiredate");
                double comm = resultSet.getDouble("comm");
                int deptno = resultSet.getInt("deptno");
                System.out.println("" + "empn"+"ename"+"job"+"mgr"+"hiredate"+
                        "comm"+"deptno"
                );
            }
            statement.close();
            connection.close();


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deletedate() {
        Connection connection=null;
        Statement statement =null;
        try {
            Class.forName(Diver);
            connection=DriverManager.getConnection(Url,root,password);
            statement= connection.createStatement();
            String sql = "delete from dept where deptno = 40;";
            int rows = statement.executeUpdate(sql);
            System.out.println("影响数据行数为"+rows);
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void testUpdate() {
        try {
            Connection connection =null;
            Statement statement=null;
            Class.forName(Diver);
            connection= DriverManager.getConnection(Url,root,password);
            statement= connection.createStatement();
            String sql ="update dept set dname='总部',loc='北京' where deptno=30";
            int rows = statement.executeUpdate(sql);
            System.out.println("影响数据"+rows);
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        }
    }
}
