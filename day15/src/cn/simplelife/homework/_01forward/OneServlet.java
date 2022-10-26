package cn.simplelife.homework._01forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName OneServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/26 8:53
 * @Version 1.0
 */

@WebServlet(value = "/one")
public class OneServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("user", "张胜男");
        System.out.println("这是第一个servlet");
        req.getRequestDispatcher("/two").forward(req, resp);
    }
}
