package cn.simplelife.work._02cookies;

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
@WebServlet(value = "/cookies/content")
public class CookieContentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = null;
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if ("username".equals(cookie.getName())) {
                username = cookie.getValue();
            }
        }
        req.setAttribute("username", username);
        req.setAttribute("content", "这是邮件内容");
        req.getRequestDispatcher("/WEB-INF/cookies/content.jsp").forward(req, resp);
    }
}