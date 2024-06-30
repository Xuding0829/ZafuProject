package cn.java.emp;


//新服务员完成用户注册
//注意:/empreg服务员名字


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/empreg")
public class EmpRegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //3:添加成功
        resp.setContentType("text/html;charset=utf-8");
        //服务员    吃啥 找厨子 送来
        //servlet  谁  找小弟  成功
        //10:45 完成任务
        //1:获取参数 name pwd job salary
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String salary = req.getParameter("salary");
        String job = req.getParameter("job");
        //2:找小弟 EmpService
        try {
            new EmpService().register(name, job,
                    salary, pwd);
        }catch(Exception e){e.printStackTrace();}

        resp.getWriter().write("添加成功");


    }
}
