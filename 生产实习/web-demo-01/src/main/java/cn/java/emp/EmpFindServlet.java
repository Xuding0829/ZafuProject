package cn.java.emp;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/find")
public class EmpFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取参数
        int id = Integer.parseInt(req.getParameter("id"));
        Empp empp= null;
        // 2. 调用小弟EmpService find方法
        try {
            empp = new EmpService().find(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 3. 修改响应格式 text/json
        resp.setContentType("text/json;charset=utf-8");
        // 4. 将emp转json字符串
        String json = JSON.toJSONString(empp);
        // 5. 发送
        resp.getWriter().write(json);
    }
}
