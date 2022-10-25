package cn.simplelife.work._03scope;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName ScopeServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/25 15:20
 * @Version 1.0
 */

@WebServlet(value = "/result")
public class ResultServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        Object reqNum = req.getAttribute("num");
        writer.println("req中的" + reqNum);
        Object sessionNum = req.getSession().getAttribute("num");
        writer.println("session中的" + sessionNum);
        Object servletContextNum = getServletContext().getAttribute("num");
        writer.println("application中的数据" + servletContextNum);
    }
}
