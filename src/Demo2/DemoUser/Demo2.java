package Demo2.DemoUser;

import util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        //1. 键盘录入，接受用户名和密码
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String UserName=sc.nextLine();
        System.out.println("请输入密码：");
        String passWord=sc.nextLine();
        //2. 调用方法
        boolean x=new Demo2().login2(UserName,passWord);
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
    public boolean login2(String userName,String password) //解决sql注入的问题
    {
        if(userName!=null &&password!=null)
        {
            Connection conn=null;
            PreparedStatement pstm =null;
            ResultSet rs=null;
            try {
                // 1.获取连接
                conn = JDBCUtils.getConnection();
                // 2.定义sql
                String sql="select * from Users where userName=? and passWord=?";
                // 3.获取执行sql的对象
                 pstm = conn.prepareStatement(sql);
                 pstm.setString(1,userName);
                 pstm.setString(2,password);
                // 4. 执行查询
                rs = pstm.executeQuery();
                // 5. 获取结果集 判断
                return rs.next();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                JDBCUtils.close(rs,pstm,conn);
            }

        }
        return false;
    }
}
