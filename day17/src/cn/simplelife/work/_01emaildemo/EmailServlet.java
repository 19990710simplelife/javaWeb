package cn.simplelife.work._01emaildemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName EmailServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/27 10:08
 * @Version 1.0
 */
@WebServlet(value = "/email/login")
public class EmailServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、解决请求中文乱码问题
        req.setCharacterEncoding("utf-8");
        //2、获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //3、模拟登录
        if (!("admin".equals(username.trim()) && "123456".equals(password.trim()))) {
            // 4、登录失败，提示错误信息
            req.setAttribute("error", "账号或密码错误");
            // 5、继续返回到登录页面
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        // 6、登录成功，共享用户信息
        req.setAttribute("username",username);
        // 7、跳转主页
        req.getRequestDispatcher("/WEB-INF/email/index.jsp").forward(req, resp);
    }
}
