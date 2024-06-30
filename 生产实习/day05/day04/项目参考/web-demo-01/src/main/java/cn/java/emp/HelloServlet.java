package cn.java.emp;

import com.alibaba.fastjson.JSON;
import com.itheima.web.Emp;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet 快速入门
 */
@WebServlet("/demo22")
public class HelloServlet implements Servlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        Emp e = new Emp();
        e.setId(1);
        e.setName("11");
        List<Emp> list = new ArrayList<>();
        list.add(e);
        String json = JSON.toJSONString(list);
        res.setContentType("text/json;charset=utf-8");
        res.getWriter().write(json);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
}
