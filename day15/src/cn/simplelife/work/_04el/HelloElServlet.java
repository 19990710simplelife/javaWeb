package cn.simplelife.work._04el;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @ClassName HelloElServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/25 15:48
 * @Version 1.0
 */

@WebServlet(value = "/hello/el")
public class HelloElServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("msg", "你好！大傻子！");
        req.getSession().setAttribute("msg", "你好，大傻逼！");
        req.getServletContext().setAttribute("msg", "你好，二货");

        req.getRequestDispatcher("/el/hello.jsp").forward(req,resp);
    }
}
