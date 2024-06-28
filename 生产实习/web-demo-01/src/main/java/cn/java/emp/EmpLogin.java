package cn.java.emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 创建servlet类 完成员工登录
@WebServlet("/emplogin")
public class EmpLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 输出结果servlet
        // 1.问吃啥             获取用户参数, name, pwd
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        // 2.找厨子做饭，拿过来   EmpService.login
        boolean rs = false;
        try {
            rs = new EmpService().login(uname, upwd);
        } catch (Exception e) {
           e.printStackTrace();
        }
        String str = "登陆失败 login error";
        if(rs == true) {
            str = "登陆成功 login successfully";
        }
        // 3.给客户             登录成功,登陆失败
        resp.getWriter().write(str);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
