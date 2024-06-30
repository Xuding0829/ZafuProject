package cn.java.emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * servlet小弟
 * 连接数据 查询  结果
 */
public class EmpService {

    //创建方法完成用户登录
    //返回值 boolean true 登录成功 false登录失败
    //name 用户名  pwd 密码
    public boolean login(String name,String pwd)throws Exception{
        //1:创建数据库连接
        Connection conn =
                DBUtils.getConnection();
        //2:创建sql语句
        String sql = "SELECT COUNT(id) as c ";
         sql+=" from t_emp  where name='"+name+"' and pwd='"+pwd+"'";
        //3:创建stmt对象
        Statement stmt = conn.createStatement();
        //4:执行sql语句
        ResultSet rs = stmt.executeQuery(sql);
        //5:获取返回结果
        boolean result = false;
        if(rs.next()){
           int c =  rs.getInt("c");
           if(c==1){
               result = true;
           }
        }
        //6:判断是否查询结果
        //rs.close();
        //7:返回true false
        //conn.close();
        return result;
    }

    /**
     * 完成用户注册
     * @param name
     * @param job
     * @param salary
     * @param pwd
     * @return
     */
    public boolean register(String name,
                            String job,
                            String salary,
                            String pwd)throws Exception{
       //1:创建数据库连接
        Connection conn =
                DBUtils.getConnection();
       //2:创建sql语句
        String sql = "insert into t_emp" +
                " values(null,?,?,?,?)";
       //3:创建statm对象
        PreparedStatement stmt =
                conn.prepareStatement(sql);
        //4:绑定参数
        stmt.setString(1,name);
        stmt.setString(2,salary);
        stmt.setString(3,job);
        stmt.setString(4,pwd);
       //5:执行sql语句
        stmt.execute();
       //6:返回结果 true
        return true;
    }


    //创建函数查询雇员表所有数据  16:55 完成任务
    public List<Empp> list()throws Exception{
       //1:创建连接对象
        Connection conn =
                DBUtils.getConnection();
       //2:创建sql语句
        String sql = "select * from t_emp";
       //3:创建stmt对象
        Statement stmt = conn.createStatement();
        //4:执行stmt对象并且获取结果
        ResultSet resultSet = stmt.executeQuery(sql);
        //5:创建空集合对象List
        List<Empp> items = new ArrayList<Empp>();
       //6:创建循环遍历resultset
        while (resultSet.next()) {
            //7:创建Empp对象
            Empp e = new Empp();
            //8:从数据库获取对应数据赋值对象中
            e.setId(resultSet.getInt("id"));
            e.setJob(resultSet.getString("job"));
            e.setName(resultSet.getString("name"));
            e.setSalary(resultSet.getString("salary"));
            //9:将对添加集合中
            items.add(e);
        }
       //10:在循环外返回集合对象
        return items;
    }

    //删除 条件一定id
    public void remove(int id)throws Exception{
        //1:创建连接对象
        Connection conn = null;
                conn = DBUtils.getConnection();
        //2:创建sql语句
        String sql = "delete from t_emp where id = ?";
        //3:创建stmt对象
        PreparedStatement stmt =
                conn.prepareStatement(sql);
        //4:绑定参数
        stmt.setInt(1,id);
        //5:执行
        stmt.execute();
    }

    //依据id查询所有用户信息
    public Empp findById(int id)throws Exception{
        //1:创建连接对象
        Connection conn =
                DBUtils.getConnection();
        //2:创建sql语句
        String sql = "select * from t_emp where id = "+id;
        //3:创建stmt对象
        Statement stmt = conn.createStatement();
        //4:执行stmt对象并且获取结果
        ResultSet resultSet = stmt.executeQuery(sql);
        Empp e = null;
        //6:创建循环遍历resultset
        if (resultSet.next()) {
            //7:创建Empp对象
            e = new Empp();
            //8:从数据库获取对应数据赋值对象中
            e.setId(resultSet.getInt("id"));
            e.setJob(resultSet.getString("job"));
            e.setName(resultSet.getString("name"));
            e.setSalary(resultSet.getString("salary"));
        }
        return e;
    }
    //依据id更新薪水
    public void updateSalById(int id ,String salary)throws Exception{
        //1:创建连接对象
        Connection conn = null;
        conn = DBUtils.getConnection();
        //2:创建sql语句
        String sql = "update t_emp set salary = ? where id = ?";
        //3:创建stmt对象
        PreparedStatement stmt =
                conn.prepareStatement(sql);
        //4:绑定参数
        stmt.setString(1,salary);
        stmt.setInt(2,id);
        //5:执行
        stmt.execute();
    }

    public static void main(String[] args) throws Exception{
       //boolean rs =  new EmpService().login("tom","123");
       //System.out.println(rs);
       //boolean rs =  new EmpService().register(
       //        "james","manager",
       //        "19000","123");
       //System.out.println(rs);
       //boolean rs =  new EmpService().login("james",
       //        "123");
       //System.out.println(rs);
       // List<Empp> items = new EmpService().list();
       // System.out.println(items);
       // new EmpService().remove(6);
        new EmpService().updateSalById(2,"123456");
        System.out.print(new EmpService().findById(2));
    }
}
