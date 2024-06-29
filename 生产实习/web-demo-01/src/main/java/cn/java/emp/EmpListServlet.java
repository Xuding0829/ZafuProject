package cn.java.emp;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/list")
public class EmpListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Empp> Empps = null;
        try {
            Empps = new EmpService().list();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // resp.getWriter().write(Empps.toString());
        // 将查询数据库的用户列表转成json
        // 将list数据转成json字符串
        String json = JSON.toJSONString(Empps);
        // 指定字符格式
        resp.setContentType("text/json;charset=utf-8");
        // 发送数据
        resp.getWriter().write(json);
    }
}
