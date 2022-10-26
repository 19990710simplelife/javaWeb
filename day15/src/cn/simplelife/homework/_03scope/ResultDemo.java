package cn.simplelife.homework._03scope;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.HashMap;

/**
 * @ClassName ResultDemo
 * @Description
 * @Author simplelife
 * @Date 2022/10/26 9:11
 * @Version 1.0
 */

@WebServlet(value = "/scope/result")
public class ResultDemo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        Object num = req.getAttribute("num");
        Object num1 = req.getSession().getAttribute("num");
        Object num2 = req.getServletContext().getAttribute("num");
        writer.println("req中的：" + num);
        writer.println("session中的：" + num1);
        writer.println("servletContext中的：" + num2);
    }
}
