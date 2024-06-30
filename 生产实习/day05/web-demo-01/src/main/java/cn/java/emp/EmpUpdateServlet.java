package cn.java.emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class EmpUpdateServlet extends HttpServlet {
    //如果用户注册 添加用户 添加商品
    //   更新用户  更新商品一定用post
    //   post
    //     --post 接收大量数据(上传图片)
    //     --post 在请求主体中(不会出现中乱码)
    //   get
    //   用户登录  用户查询 查询列表 查询订单 搜索商品
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1:指定请求对象数据格式utf-8(最好第一行)
        req.setCharacterEncoding("utf-8");
        //2:获取参数 id salary
        int id = Integer.parseInt(
                req.getParameter("id")
        );
        String salary = req.getParameter("salary");
        //3:调用小弟 EmpService 更新
        try {
            new EmpService().updateSalById(id, salary);
        }catch(Exception ex){ex.printStackTrace();}
        //4:指定响应数据格式json
        resp.setContentType("text/json/charset=utf-8");
        //5:发送响应  更新成功
        resp.getWriter().write("{'code':0,'msg':'ok'}");
    }
}
