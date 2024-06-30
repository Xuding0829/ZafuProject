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
        //1:获取参数 id
        int id =
                Integer.parseInt(
                        req.getParameter("id")) ;
        //2:调用小弟EmpService find方法
        Empp e = null;
        try {
            e = new EmpService().findById(id);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        //3:修改响应格式 text/json
        String json = JSON.toJSONString(e);
        //4:将Emp转json字符串
        resp.setContentType("text/json;charset=utf-8");
        //5:发送
        resp.getWriter().write(json);
    }
}
