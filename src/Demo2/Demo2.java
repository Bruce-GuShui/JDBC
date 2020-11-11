package Demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    练习：在数据库MyTestDemo 下的 emp表删除一条记录
 */
public class Demo2 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        try {
            //1. 设置数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2. 定义sql语句
            String sql="delete from emp where ID=7";

            //3. 定义connection对象
           conn=DriverManager.getConnection("jdbc:mysql:///MyTestDemo","root","yuc46938");

           //4. 获取statement对象
            stmt=conn.createStatement();
            //5. 执行sql
            int i = stmt.executeUpdate(sql);
            if(i>0)
            {
                System.out.println("删除成功");
            }
            else
            {
                System.out.println("删除失败");
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
        }
    }
}
