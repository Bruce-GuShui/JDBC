package Demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
        练习：在数据库MyTestDemo 下的 emp表修改一条记录
 */
public class Demo1 {
    public static void main(String[] args) {
        Statement stmt=null;
        Connection conn=null;

        //1. 添加驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2. 定义sql 语句
            String sql="update emp set GENDER='男',Salary=39000,joint_date='2020-08-19',dept_id=2 where ID=8";

            //3. 获取连接对象
            conn= DriverManager.getConnection("jdbc:mysql:///MyTestDemo","root","yuc46938");

            //4. 获取执行sql的对象statement
            stmt=conn.createStatement();

            //5. 执行sql
            int i = stmt.executeUpdate(sql);
            if(i>0)
            {
                System.out.println("数据修改成功");
            }
            else
            {
                System.out.println("数据修改失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(stmt !=null)
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
