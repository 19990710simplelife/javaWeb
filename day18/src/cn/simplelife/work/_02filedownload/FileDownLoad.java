package cn.simplelife.work._02filedownload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @ClassName FileDownLoad
 * @Description
 * @Author simplelife
 * @Date 2022/10/28 16:09
 * @Version 1.0
 */
@WebServlet(value = "/download")
public class FileDownLoad extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收用户要下载的文件名称
        req.setCharacterEncoding("utf-8");
        String fileName = req.getParameter("fileName");
        //在响应之前做其他操作
        System.out.println("扣钱");
        //在项目下找到文件并响应给用户
        String realPath = req.getServletContext().getRealPath("/WEB-INF/download/");
        // 获取浏览器类型
        String header = req.getHeader("User-Agent");
        // 根据浏览器类型设置文件下载的名称
        String name = header.contains("MSIE") ? URLEncoder.encode(fileName, StandardCharsets.UTF_8) : new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        resp.setHeader("Content-Disposition", "attachment;filename=" + name);
        //复制文件
        //Paths.get(realPath, fileName) 获取到文件的真实路径
        //Files.copy(Path,输出流)
        Files.copy(Paths.get(realPath, fileName), resp.getOutputStream());
    }
}
