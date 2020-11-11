package Demo2.EmpDemp;

import Demo2.Demo2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
    定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回。
 */
public class Demo {
    public static void main(String[] args) {
        List<Emp> list = new Demo().findAll();
        for(Emp s:list)
        {
            System.out.println(s.toString());
        }
    }
    // 查询所有emp 对象
    public List<Emp> findAll()
    {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        List<Emp> list=null;
        //1. 数据库驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///Demo_20200817", "root", "yuc46938");
            String sql="select * from emp";
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            Emp emp=null;
            list=new ArrayList<Emp>();
            while(rs.next())
            {
                //获取数据
                /*
                private int id;
                private String name;
                private int job_id;
                private int mgr;
                private Date joinDate;
                private double salary;
                private double bounds;
                private int dept_id;
                 */
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joinDate = rs.getDate("joinDate");
                double salary = rs.getDouble("salary");
                double bonus=rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                emp=new Emp();
                emp.setId(id);
                emp.setName(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoinDate(joinDate);
                emp.setSalary(salary);
                emp.setBounds(bonus);
                emp.setDept_id(dept_id);
                list.add(emp);
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
        return list;
    }
}
