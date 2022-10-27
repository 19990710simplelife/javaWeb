package cn.simplelife.work._01emaildemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName EmailServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/27 10:08
 * @Version 1.0
 */
@WebServlet(value = "/email/content")
public class EmailContentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、解决请求中文乱码问题
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        req.setAttribute("username",username);
        req.setAttribute("content", "这是邮件内容");
        req.getRequestDispatcher("/WEB-INF/email/content.jsp").forward(req, resp);
    }
}
