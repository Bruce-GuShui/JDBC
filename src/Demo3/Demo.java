package Demo3;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
    测试事务
    2020-08-26


 */
public class Demo {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstatms1=null;
        PreparedStatement pstatms2=null;
        //1. 获取数据连接
        try {
            conn = JDBCUtils.getConnection();
                //开启事物
            conn.setAutoCommit(false);
            //2.定义sql
                //1. 张三-500
            String sql="update Account set Balance=Balance-? where Name=?";
                //2. 李四+500
            String sql2="update Account set Balance=Balance+? where Name=?";

            //3.获取执行sql对象
            pstatms1 = conn.prepareStatement(sql);
            pstatms1.setInt(1,500);
            pstatms1.setString(2,"zhangsan");
            pstatms2 = conn.prepareStatement(sql2);
            pstatms2.setInt(1,500);
            pstatms2.setString(2,"lisi");

            //4. 执行sql语句
            pstatms1.executeUpdate();
            int i=3/0;
            pstatms2.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                if(conn!=null) {
                    conn.rollback();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }
        finally {
            if(pstatms1!=null)
            {
                try {
                    pstatms1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(pstatms2!=null)
            {
                try {
                    pstatms2.close();
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
