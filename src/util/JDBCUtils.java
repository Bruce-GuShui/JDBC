package util;

import com.mysql.cj.protocol.Resultset;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/*
    JDBC的工具类

    获取连接的方法（不想传递参数，还得保证工具类的通用性）
    解决方案：通过配置文件来解决问题（定义参数）。

 */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    static{
        try {
            //读取配置资源文件，获取值
            //1. Properties集合类
            Properties pro=new Properties();
//            pro.load(new FileReader("/Users/lizhilong/IdeaProjects/JDBC/src/jdbc.properties"));
            /*绝对路径不合适，因为如果修改，则需要修改代码。
              这时获取src路径下文件的方式--ClassLoader 类加载器
             */
            ClassLoader classLoader=JDBCUtils.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties");
            String patch=resource.getPath();
//            System.out.println(patch);
            //3.获取属性赋值
            pro.load(new FileReader(patch));
            url=pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            driver=pro.getProperty("driver");
            //4, 注册驱动
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //连接对象的工具类
    public static Connection getConnection() throws SQLException
    {
        /*
        配置文件的读取只需要一次，得到这些值即可
         */

        return DriverManager.getConnection(url,user,password);
    }

    //释放资源工具类
    public static void close(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
   // @Override
    public static void close(ResultSet rs,Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
        }
