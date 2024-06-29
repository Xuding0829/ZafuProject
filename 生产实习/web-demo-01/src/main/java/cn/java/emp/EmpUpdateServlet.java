package cn.java.emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class EmpUpdateServlet extends HttpServlet {
    // 如果用户注册 添加用户 添加商品
    // 更新用户 更新商品一定要用post
    // post - 接受大量数据
    // post - 在请求主题中（不会出现乱码）

    // get
    // 用户登录 查询列表 查询订单 搜索商品
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 指定请求对象数据格式utf8(最好第一行)
        resp.setCharacterEncoding("utf-8");
        // 获取参数 id salary
        int id = Integer.parseInt(req.getParameter("id"));
        String salary = req.getParameter("salary");
        // 调用小弟 EmpService 更新
        try {
            new EmpService().update(id, salary);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 指定相应的数据格式json
        resp.setContentType("text/json;charset=utf-8");
        // 发送响应
        resp.getWriter().write("发送成功");
    }
}
