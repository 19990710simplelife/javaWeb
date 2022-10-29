package cn.simplelife.work._03demo.web.servlet;

import cn.simplelife.work._03demo.dao.IUsersDAO;
import cn.simplelife.work._03demo.dao.impl.IUsersDAOImpl;
import cn.simplelife.work._03demo.domain.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PipedReader;

/**
 * @ClassName LoginServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/28 20:07
 * @Version 1.0
 */
@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    private IUsersDAO iUsersDAO = new IUsersDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Users users = new Users(null, username, password, null);
        Users check = iUsersDAO.check(users);
        if (check == null) {
            req.setAttribute("error", "用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
        // 登录成功
        HttpSession session = req.getSession();
        session.setAttribute("USERS_IN_SESSION", check);
        resp.sendRedirect("/product");
    }
}
