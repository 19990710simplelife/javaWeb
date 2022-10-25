package cn.simplelife.work._01forward;

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

@WebServlet(value = "/forward/oneServlet")
public class OneServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        System.out.println("one——begin——username = " + username);
        System.out.println("---------------------------------------");

        // 跳转到forward/twoServlet做响应打印用户名
        req.getRequestDispatcher("/forward/twoServlet").forward(req, resp);
        System.out.println("第一个跳转后servlet执行");

        // 第一个servlet做响应 此时的响应不会做出响应
//        PrintWriter writer = resp.getWriter();
//        writer.println("第一个servlet结束");
    }
}
