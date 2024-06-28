package cn.java.emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 新服务员完成用户注册
// 注意:/emgreg服务员名字
@WebServlet("/empreg")
public class EmpRegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        // 服务员 吃啥 找厨子 送来
        // servlet 谁 找小弟 成功
        // 1. 获取参数 name, pwd, job, salary
        String name = req.getParameter("name");
        String pwd =  req.getParameter("pwd");
        String job = req.getParameter("job");
        String salary = req.getParameter("salary");
        // 2. 找小弟
        boolean rs = false;
        try {
            rs = new EmpService().register(name, job, salary, pwd);
        } catch (Exception e) {
          e.printStackTrace();
        }
        String str = "register 失败";
        // 3. 添加成功
        if(rs == true){
            str = "register success 成功";
        }
        resp.getWriter().println(str);
    }
}
