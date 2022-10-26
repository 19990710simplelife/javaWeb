package cn.simplelife.homework._01forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName TwoServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/26 8:55
 * @Version 1.0
 */

@WebServlet(value = "/two")
public class TwoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        Object user = req.getAttribute("user");
        writer.println(user);
    }
}
