package Demo2;

import java.sql.*;

public class Demo4 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            //1. 设置数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2. 定义sql语句
            String sql="select * from emp";

            //3. 定义connection对象
            conn= DriverManager.getConnection("jdbc:mysql:///MyTestDemo","root","yuc46938");

            //4. 获取statement对象
            stmt=conn.createStatement();
            //5. 执行sql
            rs=stmt.executeQuery(sql);

            //处理结果，使用while循环，来判断是否有下一行
            while(rs.next())
            {
                //循环判断游标是否是最后一行末尾
                //获取数据，并打印数据
                int anInt = rs.getInt(1);
                String name = rs.getString(2);
                String gender = rs.getString(3);
                double salary = rs.getDouble(4);
                Date date =rs.getDate(5);
                String dept=rs.getString(6);
                System.out.println(anInt+"--"+name+"--"+gender+"--"+salary+"--"+date+"--"+dept);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(stmt!=null)
            {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
