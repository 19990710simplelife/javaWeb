package cn.simplelife.work._03session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @ClassName SessionLoginServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/27 16:27
 * @Version 1.0
 */
@WebServlet(value = "/session/login")
public class SessionLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (!("张三".equals(username.trim()) && "123456".equals(password.trim()))) {
            req.setAttribute("error", "用户名或密码错误");
            req.getRequestDispatcher("/login2.jsp").forward(req, resp);
            return;
        }
        // 登录成功将用户数据存储到session中
        HttpSession session = req.getSession();
        String id = session.getId();
        session.setAttribute("username",username);
        // 设置session的最大活动时间 单位：秒
        session.setMaxInactiveInterval(10);
        req.setAttribute("jsessionid",id);
        req.getRequestDispatcher("/WEB-INF/session/index.jsp").forward(req, resp);
    }
}
