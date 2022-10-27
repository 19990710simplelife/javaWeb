package cn.simplelife.work._01emaildemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName EmailListServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/27 10:22
 * @Version 1.0
 */
@WebServlet(value = "/email/list")
public class EmailListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        req.setAttribute("username",username);
        List<String> list = Arrays.asList("邮件1", "邮件2");
        req.setAttribute("list", list);
        req.getRequestDispatcher("/WEB-INF/email/list.jsp").forward(req, resp);
    }
}
