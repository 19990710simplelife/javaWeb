package cn.simplelife.web.servlet;


import cn.simplelife.dao.IUsersDAO;
import cn.simplelife.dao.impl.IUsersDAOImpl;
import cn.simplelife.domain.Users;
import cn.simplelife.service.IUserService;
import cn.simplelife.service.impl.IUserServiceImpl;

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
@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    private IUserService iUserService = new IUserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Users users = new Users(null, username, password, null);
        try {
            Users check = iUserService.login(users);
            HttpSession session = req.getSession();
            session.setAttribute("USERS_IN_SESSION", check);
            resp.sendRedirect("/product");
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
        // 登录成功

    }
}
