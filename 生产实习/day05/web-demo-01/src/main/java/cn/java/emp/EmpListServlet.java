package cn.java.emp;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class EmpListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         List<Empp> items = null;
         try {
             items = new EmpService().list();
         }catch(Exception e){
             e.printStackTrace();
         }
         //resp.getWriter().write(items.toString());
         //将查询数据库用户列表转json
        //1:将List数据转json字符串
        String json = JSON.toJSONString(items);
        //2:指定发送数据库格式json
        resp.setContentType("text/json;charset=utf-8");
        //3:发送数据
        resp.getWriter().write(json);
    }
}
