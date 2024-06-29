package cn.java.emp;

import com.itheima.web.DBUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
* servlet小弟
* 连接数据 查询 结果
*/
public class EmpService {
    // 创建方法完成用户登录
    // 返回值，boolean true - 登陆成功 false - 登陆失败
    // name 用户名 pwd 密码
    public boolean login(String name, String pwd) throws Exception {
        // 1. 创建数据库连接
        Connection conn = DBUtils.getConnection();
        // 2. 创建SQL语句
        String sql = "select count(id) as c from t_emp where name = '"+name+"' and pwd = '"+ pwd+ "'";
        // 3. 创建stmt对象
        Statement stmt = conn.createStatement();
        // 4. 执行sql语句
        ResultSet rs = stmt.executeQuery(sql);
        // 5. 获取返回结果
        boolean result = false;
        if(rs.next())
        {
            int c = rs.getInt("c");
            if(c == 1) {
                result = true;
            }
        }
        // 6. 判断是否查询结果
        rs.close();
        // 7. 返回 true / false
        conn.close();
        return result;
    }

    public boolean register(String name, String job, String salary, String pwd) throws Exception {
        // 1. 创建数据库连接
        Connection conn = DBUtils.getConnection();
        // 2. 创建sql语句
        String sql = "insert into t_emp values(null, ?, ?, ?, ?)";
        // 3. 创建statm对象
        PreparedStatement stmt = conn.prepareStatement(sql);
        // 4. 绑定参数
        stmt.setString(1, name);
        stmt.setString(2,salary);
        stmt.setString(3,job);
        stmt.setString(4, pwd);
        // 5. 执行sql语句
        stmt.executeUpdate();
        // 6. 返回结果 true
        return true;
    }

    public List<Empp> list() throws SQLException {
        // 创建连接对象
        Connection conn = DBUtils.getConnection();
        // 创建sql语句
        String sql = "select * from t_emp";
        // 创建stmt对象
        Statement stmt = conn.createStatement();
        // 执行stmt对象并获取结果
        ResultSet rs = stmt.executeQuery(sql);
        // 创捷空集合对象list
        List<Empp> Empps = new ArrayList<Empp>();
        // 创建循环 遍历集合resultset
        while(rs.next()) {
            // 从数据库中创建空对象
            Empp empp = new Empp();
            // 从数据库中获取对象
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String job = rs.getString("job");
            String salary = rs.getString("salary");
            empp.setId(id);
            empp.setName(name);
            empp.setJob(job);
            empp.setSalary(salary);
            // 将对象添加到集合中
            Empps.add(empp);
        }
        // 在循环外返回集合对象
        rs.close();
        conn.close();
        stmt.close();
        return Empps;
    }

    public void remove(int id) throws Exception {
        // 创建连接对象
        Connection conn = DBUtils.getConnection();
        // 创建sql语句
        String sql = "delete from t_emp where id = " + id;
        // 创建stmt对象
        PreparedStatement stmt = conn.prepareStatement(sql);
        // 绑定参数
        stmt.setInt(1, id);
        // 执行
        stmt.executeUpdate();
        conn.close();
        stmt.close();
    }

    public Empp find(int id) throws Exception {
        // 创建连接对象
        Connection conn = DBUtils.getConnection();
        // 创建sql语句
        String sql = "select * from t_emp where id = " + id;
        // 创建stmt对象
        Statement stmt = conn.createStatement();
        // 执行stmt对象并获取结果
        ResultSet rs = stmt.executeQuery(sql);

        Empp empp = null;
        // 创建循环 遍历集合resultset
        if(rs.next()) {
            // 从数据库中创建空对象
            empp = new Empp();
            // 从数据库中获取对象
            id = rs.getInt("id");
            String name = rs.getString("name");
            String job = rs.getString("job");
            String salary = rs.getString("salary");
            empp.setId(id);
            empp.setName(name);
            empp.setJob(job);
            empp.setSalary(salary);
        }
        // 在循环外返回集合对象
        rs.close();
        conn.close();
        stmt.close();
        return empp;
    }

    public boolean update(int id, String salary) throws Exception {
        // 创建连接对象
        Connection conn = DBUtils.getConnection();
        // 创建sql语句
        String sql = "update t_emp set salary = ? where id = ?";
        // 创建stmt对象
        PreparedStatement stmt = conn.prepareStatement(sql);
        // 绑定参数
        stmt.setString(1, salary);
        stmt.setInt(2, id);
        // 执行
        stmt.executeUpdate();
//        conn.close();
//        stmt.close();
        return true;
    }

    public static void main(String[] args) throws Exception {
//      boolean rs = new EmpService().register("admin", "manager", "19000","123");
//      System.out.println(rs);
//      boolean rs = new EmpService().login("admin","123");
//      System.out.println(rs);
//      List<Empp> Empps = new EmpService().list();
//      System.out.println(Empps);
        boolean rs = new EmpService().update(2, "1234567");
        System.out.println(new EmpService().find(2));
    }
}
