package cn.java.emp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/upload2")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setCharacterEncoding("utf-8");
        //System.out.println(req.getContextPath());
        //System.out.println(req.getParameter("param1"));

        System.out.println("FileUploadServlet被调用了");
        //1，判断是不是文件表单(enctype="multipart/form-data")
        if (ServletFileUpload.isMultipartContent(req)) {
            //2.创建DiskFileItemFactory对象，用于构建一个解析上传数据的工具对象
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            //3. 创建一个解析上传数据的工具对象
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            //解决接收到文件名是中文乱码问题
            servletFileUpload.setHeaderEncoding("utf-8");
            //4. 关键是servletFileUpload对象可以把表单提交的数据text/文件
            //将其封装到FileItem文件项中
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                //System.out.println("list==>" + list);
                for (FileItem fileItem : list) {
                    //System.out.println("fileItem =" + fileItem);
                    if (fileItem.isFormField()) { //如果为真就是文本input text
                        String name = fileItem.getString("utf-8");
                        System.out.println("....: " + name);
                    }else { //是一个文件
                        upload(req,fileItem);
                        //5.提示信息
                        resp.setContentType("text/html;charset=utf-8");
                        resp.getWriter().write("上传成功");

                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }else {
            System.out.println("不是文件表单...");
        }

    }




    public void upload(HttpServletRequest request,FileItem fileItem) throws Exception {
        String name = fileItem.getName();
        System.out.println("上传的文件名=" + name);
        //1.把这个上传到服务器的temp下的文件保存到指定的目录
        String filePath = "/upload/";
        //2.获取完整目录
        String realPath = request.getServletContext().getRealPath(filePath);
        //3. 创建这个上传的目录=>创建目录
        File fileDirectory = new File(realPath + WebUtils.getYearMonthDay());
        if (!fileDirectory.exists()) { //不存在就创建
            fileDirectory.mkdirs(); //创建
        }

        //4.将文件拷贝到fileDirectory
        // 构建一个上传文件的完整路径: 目录+文件名
        // 对上传的文件名进行处理，前面增加一个前缀，保证是唯一即可
        // ds943woues893290ewues8932890_17226363_a.jpg
        name = UUID.randomUUID().toString()+"_" + System.currentTimeMillis() +"_"+ name;
        fileItem.write(new File(fileDirectory +"/" + name));
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("param1"));
    }
}
