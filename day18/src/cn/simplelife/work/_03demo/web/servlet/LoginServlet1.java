package cn.simplelife.work._03demo.web.servlet;

import cn.simplelife.work._03demo.dao.IUsersDAO;
import cn.simplelife.work._03demo.dao.impl.IUsersDAOImpl;
import cn.simplelife.work._03demo.domain.Users;
import cn.simplelife.work._03demo.service.IUserService;
import cn.simplelife.work._03demo.service.impl.IUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName LoginServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/28 20:07
 * @Version 1.0
 */
@WebServlet(value = "/logins")
public class LoginServlet1 extends HttpServlet {
    private IUserService iUserService = new IUserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 将参数封装成对象
        Users users = new Users(null, username, password, null);
        try {
            // 调用业务层
            Users user = iUserService.login(users);
            HttpSession session = req.getSession();
            session.setAttribute("USERS_IN_SESSION", user);
            resp.sendRedirect("/product");
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }
}
