import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC01 {
    private static String Diver="com.mysql.cj.jdbc.Driver";
    private static String Url = "jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String root="root";
    private static String password="123456";
    public static void main(String[] args)  {
        try {
            //加载驱动
            Class.forName(Diver);
            //获得连接
            Connection connection = DriverManager.getConnection(Url,root,password);
            //获得语句对象
            Statement statement = connection.createStatement();
            // 只为指定的两列提供对应的两个值
            String sql="insert into dept values(20,'教学部','太原');";
            int rows = statement.executeUpdate(sql);
            System.out.println("影响数据行数为:"+rows);

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
