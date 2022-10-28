package cn.simplelife.work._01fileupload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName FileUploadServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/28 10:53
 * @Version 1.0
 */
@MultipartConfig(maxFileSize = 1024 * 500, maxRequestSize = 1024 * 500)
@WebServlet(value = "/register")
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、上传文件的基本使用
//        req.setCharacterEncoding("utf-8");
//        String username = req.getParameter("username");
        // 获取文件
//        Part headImg = req.getPart("headImg");
        // 获取文件提交时的名称
//        String submittedFileName = headImg.getSubmittedFileName();
//        headImg.write("F:\\JavaWeb\\javaweb\\day18\\web\\upload\\" + submittedFileName);

        // 2、生成唯一的文件名称----->防止用户上传相同的文件名称覆盖掉之前的文件信息
        //req.setCharacterEncoding("utf-8");
        //String username = req.getParameter("username");
        // 获取文件
        //Part headImg = req.getPart("headImg");
        // 获取提交时的文件名称
        //String submittedFileName = headImg.getSubmittedFileName();
        // 生成唯一的文件名称
        //String filenamePre = UUID.randomUUID().toString();
        // 获取文件的拓展名称
        //String substring = submittedFileName.substring(submittedFileName.lastIndexOf("."));
        // 保存文件名称
        //String realName = filenamePre + substring;
        // 保存文件到磁盘
        //headImg.write("F:\\JavaWeb\\javaweb\\day18\\web\\upload\\" + realName);

        // 3、文件保存位置的问题
        //req.setCharacterEncoding("utf-8");
        //String username = req.getParameter("username");
        // 获取文件
        //Part headImg = req.getPart("headImg");
        // 获取文件提交时的文件名称
        //String submittedFileName = headImg.getSubmittedFileName();
        // 生成唯一的文件名称
        //String realName = UUID.randomUUID().toString() + submittedFileName.substring(submittedFileName.lastIndexOf("."));
        // 自动获取项目路径的根路径，然后拼接上给的路径
        //String baseDir = req.getServletContext().getRealPath("/upload/");
        // 将上传的文件写入文件
        //headImg.write(baseDir + realName);

        // 4、文件上传类型约束
        //req.setCharacterEncoding("utf-8");
        //String username = req.getParameter("username");
        // 获取文件
        //Part headImg = req.getPart("headImg");
        // 判断文件的类型是否为图片类型，不是图片类型不上传
        //if (headImg.getContentType().startsWith("image/")) {
        // 获取文件上传时的名称
        //String submittedFileName = headImg.getSubmittedFileName();
        // 生成唯一的文件名称
        //String realName = UUID.randomUUID().toString() + submittedFileName.substring(submittedFileName.lastIndexOf("."));
        // 自动获取文件的根路径
        //String baseDir = getServletContext().getRealPath("/upload/");
        // 将上传的文件写入文件
        //headImg.write(baseDir + realName);
        //}

        // 5、文件上传大小的限制
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        try {
            // 获取上传的文件 ---多个文件
            Collection<Part> parts = req.getParts();
            // 遍历多个文件
            for (Part part : parts) {
                // 获取每一个文件的文件名称
                String contentType = part.getContentType();
                if (contentType != null && contentType.startsWith("image/")) {
                    // 获取每一个文件上传的文件名称
                    String submittedFileName = part.getSubmittedFileName();
                    // 生成唯一的文件名称
                    String realName = UUID.randomUUID().toString() + submittedFileName.substring(submittedFileName.lastIndexOf("."));
                    // 获取保存的根路径
                    String baseDir = req.getServletContext().getRealPath("/upload/");
                    // 写入文件
                    part.write(baseDir + realName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "亲，文件太大了！");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}
