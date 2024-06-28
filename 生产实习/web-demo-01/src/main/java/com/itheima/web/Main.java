package com.itheima.web;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception{
        Emp e = new Emp();
                e.setId(1);
        e.setName("666");
        //addGoddess(e);
        //up(e);
        //find();
        del();
    }
        //增加
        public static void addGoddess(Emp e) throws Exception {
            //获取连接
            Connection conn = DBUtils.getConnection();
            //sql
            String sql = "INSERT INTO emp(id, name)"
                    +"values(null,?)";
            //预编译
            PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行
            ptmt.setString(1, e.getName());
            //执行
            ptmt.execute();
        }
        public static void up(Emp e)throws Exception{
            //获取连接
            Connection conn = DBUtils.getConnection();
            //sql
            String sql = "UPDATE  emp set name = ? where id = ?";
            //预编译
            PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行
            ptmt.setString(1, e.getName());
            ptmt.setInt(2, e.getId());

            //执行
            ptmt.execute();
        }

    public static void find()throws Exception{
        //获取连接
        Connection conn = DBUtils.getConnection();
        //sql
        String sql = "select * from emp ";
        //预编译
        //PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Emp> gs = new ArrayList<Emp>();
        Emp g = null;
        while(rs.next()){
            g = new Emp();
            g.setName(rs.getString("name"));
            g.setId(rs.getInt("id"));

            gs.add(g);
        }

        //执行
        System.out.println(gs);
    }


    public static void del()throws Exception{
        //获取连接
        Connection conn = DBUtils.getConnection();
        //sql
        String sql = "DELETE from   emp  where id = ?";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行
        ptmt.setInt(1, 1);

        //执行
        ptmt.execute();
    }
    }
