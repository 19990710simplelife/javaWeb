package cn.simplelife.work._03session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName SessionListServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/27 16:27
 * @Version 1.0
 */
@WebServlet(value = "/session/list")
public class SessionListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        req.setAttribute("username", username);
        List<String> list = Arrays.asList("邮件一", "邮件二", "邮件三");
        req.setAttribute("list", list);
        req.getRequestDispatcher("/WEB-INF/session/list.jsp").forward(req, resp);
    }
}
