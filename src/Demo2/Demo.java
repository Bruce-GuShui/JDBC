package Demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    练习：在数据库MyTestDemo 下的 emp表添加一条记录
 */
public class Demo {
    public static void main(String[] args) {
        Statement stmt=null;
        Connection conn=null;
        // 驱动导入一次就ok，注册驱动不用每次都写
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. 定义sql
            String sql="insert into emp values(null,'张三',null,null,null,null)";

            //3. 获取connection 对象
            conn = DriverManager.getConnection("jdbc:mysql:///MyTestDemo", "root", "yuc46938");

            //4. 获取执行sql的对象statement
            stmt=conn.createStatement();

            //5. 执行sql
            int i = stmt.executeUpdate(sql);
            //6. 处理结果
            if(i>0) {
                System.out.println("添加成功");
            }
            else
            {
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
