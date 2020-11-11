package Demo2.DemoUser;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
    需求：
        1. 通过键盘录入用户名和密码
        2. 判断用户是否登陆成功
            * 如果这个sql有查询结果，则成功，反之则失败


    步骤：
        1. 创建数据库表 User(已完成)
        2.
 */
public class Demo {
    public static void main(String[] args) {
        //1. 键盘录入，接受用户名和密码
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String UserName=sc.nextLine();
        System.out.println("请输入密码：");
        String passWord=sc.nextLine();
        //2. 调用方法
        boolean x=new Demo().login(UserName,passWord);
        //3. 判断结果，输出不同语句
        while (x==false)
        {
            System.out.println("登陆失败。请重新输入");
            sc=new Scanner(System.in);
            System.out.println("请输入用户名：");
            UserName=sc.nextLine();
            System.out.println("请输入密码：");
            passWord=sc.nextLine();

            x=new Demo().login(UserName,passWord);
            if(x==true)
            {
                System.out.println("登陆成功");
                break;
            }
        }
        sc.close();
    }

    /*
        写一个登陆方法
     */
    public boolean login(String userName,String password)
    {
        if(userName!=null &&password!=null)
        {
            Connection conn=null;
            Statement stmts=null;
            ResultSet rs=null;
            try {
                // 1.获取连接
                conn = JDBCUtils.getConnection();
                // 2.定义sql
                String sql="select * from Users where UserName='"+userName+"'and PassWord='"+password+"'";
                // 3.获取执行sql的对象
                stmts = conn.createStatement();
                // 4. 执行查询
                rs = stmts.executeQuery(sql);
                // 5. 获取结果集 判断
//                if(rs.next())
//                {
//                    return true;
//                }else
//                {
//                    return false;
//                } //垃圾代码

                return rs.next(); //取代上面的结果集，判断

            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                JDBCUtils.close(rs,stmts,conn);
            }

        }
        return false;
    }
}
