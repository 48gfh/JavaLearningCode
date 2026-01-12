import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        /**
         * 像dept表增加数据
         * */
        // 1、加载驱动Driver
        Driver driver=new com.mysql.cj.jdbc.Driver();
        //2、注册驱动 DriverManager
        DriverManager.registerDriver(driver);
        /**
         * 3、获得连接Connection
         * url:  统一资源定位符，定位我们要连接的数据库
         *      协议   jdbc:mysql
         *      IP   127.0.0.1
         *      端口  3306
         *      数据库名字 mydb
         *      参数：//ip:端口/资源路径?参数名=参数值&参数名=参数值&....
         * user: 用户名
         * password: 密码
         * */

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",
                "root",
                "123456");
        //获得语句对象
        Statement statement= connection.createStatement();
        //获得返回语句
        String sql="insert into dept values(50,'教学部','太原');";
        int rows = statement.executeUpdate(sql);
        System.out.println("影响数据行数为:"+rows);
        //6释放资源
        /*
         * 注意顺序
         * 后获得的先关闭,先获得的后关闭
         * */
        statement.close();
        connection.close();

    }
}
