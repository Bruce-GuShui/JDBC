package Demo2.EmpDemp;

import java.util.Date;

/*
    封装emp表数据的JavaBean
 */
class Emp {
    private int id;
    private String name;
    private int job_id;
    private int mgr;
    private Date joinDate;
    private double salary;
    private double bonus;
    private int dept_id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getJob_id() {
        return job_id;
    }

    public int getMgr() {
        return mgr;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public double getSalary() {
        return salary;
    }

    public double getBounds() {
        return bonus;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBounds(double bounds) {
        this.bonus = bounds;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job_id=" + job_id +
                ", mgr=" + mgr +
                ", joinDate=" + joinDate +
                ", salary=" + salary +
                ", bounds=" + bonus +
                ", dept_id=" + dept_id +
                '}';
    }
}
