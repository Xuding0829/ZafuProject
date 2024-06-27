package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// 创建数据操作工具
public class DBUtils {
    // 1: 创建四个变量
    // 数据库 url 数据库用户名 数据库密码 数据库链接
    public static final String URL = "jdbc:mysql://localhost:3306/emp?serverTimezone=Asia/Shanghai";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    public static Connection conn = null;
    // 2: 创建静态代码块
    static{
        try {
            // 2.1: 加载mysql驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.2: 获取数据库连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 3: 创建方法获取连接
    public static Connection getConnection(){
        return conn;
    }
    // 测试
    public static void main(String[] args) throws SQLException {
        // add();
         sel();
        // del();
        // System.out.print(DBUtils.getConnection());
    }
    // 添加功能：向数据库 t_emp添加一条记录
    public static void add() throws SQLException {
        // 获取连接
        Connection conn = DBUtils.getConnection();
        // 创建sql
        String sql = "insert into t_emp values(null, ?, ?, ?)";
        // 执行预编译
        PreparedStatement stmt = conn.prepareStatement(sql);
        // 添加参数
        stmt.setString(1, "jerry");
        stmt.setString(2, "11000");
        stmt.setString(3, "pro");
        // 执行
        stmt.execute();
    }
    public static void del() throws SQLException {
        // 获取连接
        Connection conn = DBUtils.getConnection();
        // 创建sql
        String sql = "delete from t_emp where id = ?";
        // 执行预编译
        PreparedStatement stmt = conn.prepareStatement(sql);
        // 添加参数
        stmt.setInt(1, 1);
        // 执行
        stmt.execute();
    }
    public static void alt() throws SQLException {
        // 获取连接
        Connection conn = DBUtils.getConnection();
        // 创建sql
        String sql = "update t_emp set salary = ? where name = ?";
        // 执行预编译
        PreparedStatement stmt = conn.prepareStatement(sql);
        // 添加参数
        stmt.setString(1, "12000");
        stmt.setString(2, "jerry");
        // 执行
        stmt.execute();
    }
    public static void sel() throws SQLException {
        // 1: 创建连接
        Connection conn = DBUtils.getConnection();
        // 2: 创建sql
        String sql = "select * from t_emp";
        // 3: 创建stmt
        PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
        // 4: 查询
        ResultSet rs = stmt.executeQuery(sql);
        // 5: 创建循环
        // 5.1 创建集合类型保存一组emp对象
        List<Emp> emps = new ArrayList<Emp>();
        while(rs.next()) {
//            System.out.println(rs.getInt("id"));
//            System.out.println(rs.getString("name"));
//            System.out.println(rs.getString("salary"));
//            System.out.println(rs.getString("job"));
            Emp e = new Emp();
            e.setId(rs.getInt("id"));
            e.setName(rs.getString("name"));
            e.setJob(rs.getString("job"));
            e.setSalary(rs.getString("salary"));
            emps.add(e);
        }
        // 6: 获取每个数据
        // 7: 循环关闭连接
        rs.close();
        conn.close();
        System.out.println(emps);
    }
}

class Emp{
    private int id; // 保存主键
    private String name; // 保存雇员名称
    private String salary; // 保存雇员薪水
    private String job; // 保存雇员职务

    public Emp() {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Emp{id=" + id + ", name='" + name + "', salary='" + salary + "', job='" + job + "'}";
    }
}
