package org.example;
import java.sql.*;
// 创建数据操作工具
public class tmp {
    // 1: 创建四个变量
    // 数据库 url 数据库用户名 数据库密码 数据库链接
    public static final String URL = "jdbc:mysql://localhost:3306/emp?serverTimezone=Asia/Shanghai&useSSL=false";
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
        PreparedStatement stmt = (PreparedStatement) conn.createStatement();
        // 4: 查询
        ResultSet rs = stmt.executeQuery(sql);
        // 5: 创建循环
        while(rs.next()) {
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("salary"));
            System.out.println(rs.getString("job"));
        }
        // 6: 获取每个数据
        // 7: 循环关闭连接
        rs.close();
        conn.close();
    }
}
