package cn.simplelife.work._03scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName ScopeServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/25 15:20
 * @Version 1.0
 */

@WebServlet(value = "/scope")
public class ScopeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //需求: 从 ScopeServlet 中获取三个作用域中的数据 num, 如果获取到则加1再存入,如果获取不到则存入
        //num 的值为1,最后跳转到 ResultServelt 中来做数据的获取和显示.
        Object num = req.getAttribute("num");
        if (num == null) {
            req.setAttribute("num", 1);
        } else {
            Integer num1 = (Integer) num;
            req.setAttribute("num", num1 + 1);
        }

        HttpSession session = req.getSession();
        Object sessionAttribute = session.getAttribute("num");
        if (sessionAttribute == null) {
            session.setAttribute("num", 1);
        } else {
            Integer integer = (Integer) sessionAttribute;
            session.setAttribute("num", integer + 1);
        }

        ServletContext servletContext = getServletContext();
        Object contextAttribute = servletContext.getAttribute("num");
        if (contextAttribute == null) {
            servletContext.setAttribute("num", 1);
        } else {
            Integer servletNum = (Integer) contextAttribute;
            servletContext.setAttribute("num", servletNum + 1);
        }

        req.getRequestDispatcher("/result").forward(req, resp);
    }
}
