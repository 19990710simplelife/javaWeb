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

@WebServlet(value = "/forward/twoServlet")
public class TwoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应格式
        resp.setContentType("text/html;charset=utf-8");

        // 获取/forward/oneServlet携带的用户名信息
        String username = req.getParameter("username");
        System.out.println("two——获取——one的username = " + username);

        // 获取输出流对象
        PrintWriter writer = resp.getWriter();

        // 响应给浏览器
        writer.println("第二个servlet响应的数据：" + username);
    }
}
