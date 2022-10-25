package cn.simplelife.work._03scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName SecondServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/25 11:37
 * @Version 1.0
 */

@WebServlet(value = "/scope/second")
public class SecondServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        Object msg = req.getAttribute("msg");

        HttpSession session = req.getSession();
        Object sessionAttribute = session.getAttribute("msg");

        ServletContext servletContext = req.getServletContext();
        Object servletContextAttribute = servletContext.getAttribute("msg");
        writer.println(msg + "</br>");
        writer.println(sessionAttribute + "</br>");
        writer.println(servletContextAttribute + "</br>");
    }
}