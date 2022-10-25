package cn.simplelife.work._02redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName OneServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/25 9:43
 * @Version 1.0
 */

@WebServlet(value = "/redirect/oneServlet")
public class OneServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        System.out.println("one——begin——username = " + username);
        System.out.println("---------------------------------------");

        // 跳转到forward/twoServlet做响应打印用户名
        resp.sendRedirect("/redirect/twoServlet");
        System.out.println("第一个跳转后servlet执行");

        // 转发可以访问到WEB-INF下的资源文件 重定向不能访问
        // 因为重定向是在浏览器端重新发起请求，转发是在服务器端进行
        // 重定向可以进行跨域访问，地址栏会发生变化
        // 转发不可以进行跨域访问，因为是在本服务器内进行转发，地址栏不会发生变化，只发生一次请求
//        req.getRequestDispatcher("/WEB-INF/hello.jsp").forward(req, resp);
        // 第一个servlet做响应 此时的响应不会做出响应
//        PrintWriter writer = resp.getWriter();
//        writer.println("第一个servlet结束");
    }
}
