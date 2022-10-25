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

@WebServlet(value = "/scope/first")
public class FirstServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求对象
        System.out.println(req);
        // 获取会话对象
        HttpSession session = req.getSession();
        System.out.println(session);
        // 获取上下文对象 三种获取方式获取的对象都是同一个
        ServletContext servletContext = getServletContext();
        System.out.println("servletContext = " + servletContext);
        System.out.println("------------------------------------------");
        ServletContext servletContext1 = req.getServletContext();
        System.out.println("servletContext1 = " + servletContext1);
        System.out.println("------------------------------------------");
        ServletContext servletContext2 = session.getServletContext();
        System.out.println("servletContext2 = " + servletContext2);
    }
}
