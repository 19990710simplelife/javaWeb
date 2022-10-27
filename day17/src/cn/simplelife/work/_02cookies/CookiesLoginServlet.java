package cn.simplelife.work._02cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName CookiesLoginServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/27 10:56
 * @Version 1.0
 */
@WebServlet(value = "/cookies/login")
public class CookiesLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (!("张三".equals(username.trim()) && "123456".equals(password.trim()))) {
            req.setAttribute("error", "用户名或密码错误");
            req.getRequestDispatcher("/login1.jsp").forward(req, resp);
            return;
        }
        //登录成功之后创建cookie保存用户信息
        Cookie cookie = new Cookie("username", username);
        //给cookies设置存活时间
        cookie.setMaxAge(60);
        //给cookies设置路径
        cookie.setPath("/");
        //将信息响应给浏览器
        resp.addCookie(cookie);
        req.setAttribute("username", username);
        req.getRequestDispatcher("/WEB-INF/cookies/index.jsp").forward(req, resp);
    }
}
