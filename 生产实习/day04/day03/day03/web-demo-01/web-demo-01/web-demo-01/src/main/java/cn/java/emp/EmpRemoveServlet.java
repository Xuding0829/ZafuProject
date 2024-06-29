package cn.java.emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/remove")
public class EmpRemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //1:获取参数
       int id =
               Integer.parseInt(req.getParameter("id"));
       //2:删除数据
        try {
            new EmpService().remove(id);
        }catch (Exception e){e.printStackTrace();}
       //3:返回结果 json
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write("{'code':0,'msg':'ok'}");
    }
}
