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
 * @ClassName FirstServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/25 11:27
 * @Version 1.0
 */

@WebServlet(value = "/scope/firstOption")
public class FirstServletOption extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从请求作用域存入数据
        req.setAttribute("msg", "req.setAttribute");
        // 从会话作用域存入数据
        HttpSession session = req.getSession();
        session.setAttribute("msg", "req.getSession()");
        // 从请求作用域存入数据
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("msg", "req.getServletContext()");
        // 跳转到第二个servlet
        req.getRequestDispatcher("/scope/second").forward(req, resp);
    }
}
