package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.cj.jdbc.Driver");

       // 3. 获取数据库连接对象
       // Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyTestDemo","root", "yuc46938");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///MyTestDemo","root", "yuc46938");
        //4. 定义SQL语句(注意sql语句后不要加分号)
        String sql="update dept set name='研发部'";

        //5. 获取执行sql的对象 statement
        Statement stmt = connection.createStatement();

        //6. 执行sql 使用statement中的update方法
        int i = stmt.executeUpdate(sql);

        //7. 处理结果
        System.out.println(i);
        //8. 释放资源
        stmt.close();
        connection.close();
    }
}
