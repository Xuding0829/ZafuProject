package com.itheima.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 创建数据操作工具
public class DBUtils {
    // 1: 创建四个变量
    // 数据库 url 数据库用户名 数据库密码 数据库链接
    public static final String URL = "jdbc:mysql://localhost:3306/emp?useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    public static Connection conn = null;
    // 2: 创建静态代码块
    static{
        try {
            // 2.1: 加载mysql驱动程序
            Class.forName("com.mysql.jdbc.Driver");
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
}