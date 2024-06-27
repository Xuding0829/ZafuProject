package org.example;
import java.sql.*;
//创建数据操作工具类
public class DBUtils {
    //1:创建四个变量
    // 数据库url 数据库用户名 数据库密码 数据库连接
    public static final String URL =
            "jdbc:mysql://localhost:3306/emp?useSSL=true";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static Connection conn = null;
    //2:创建静态代码块
    static{
        try {
            //2.1:加载mysql驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2.2:获取数据库连接
            conn = DriverManager
                    .getConnection(URL, USER, PASSWORD);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //3:创建方法获取连接
    public static Connection getConnection(){
        return conn;
    }

    //测试
    public static void main(String[] args)throws Exception{
        //System.out.print(DBUtils.getConnection());
        add();
    }

    //添加功能:向数据表 t_emp添加一条记录
    public static void add()throws Exception{
        //获取连接
        Connection conn = DBUtils.getConnection();
        //创建sql
        String sql = "INSERT INTO t_emp VALUES(null,?,?,?)";
        //执行预编译
        PreparedStatement stmt =
                conn.prepareStatement(sql);
        //添加参数
        stmt.setString(1,"jerry");
        stmt.setString(2,"11000");
        stmt.setString(3,"pro");
        //执行
        stmt.execute();
    }
    public static void del(){
        //获取数据库连接
        //创建sql语句 delete from t_emp where id = ?
        //执行预编译
        //添加参数 1 setInt(1,2)
        //执行
    }
    public static void find(){}
    public static void update(){}
}
