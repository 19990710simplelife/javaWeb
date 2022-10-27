package cn.simplelife.work._03session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName CookieContentServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/27 11:05
 * @Version 1.0
 */
@WebServlet(value = "/session/content")
public class SessionContentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        req.setAttribute("username", username);
        req.setAttribute("content", "这是邮件内容");
        req.getRequestDispatcher("/WEB-INF/session/content.jsp").forward(req, resp);
    }
}
