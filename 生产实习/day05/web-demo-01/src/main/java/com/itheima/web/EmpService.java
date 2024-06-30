package com.itheima.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class EmpService {
    public void add(Emp e)throws Exception{
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
        conn.close();
    }
}
