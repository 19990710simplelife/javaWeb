package cn.simplelife.work.demo.servlet;

import cn.simplelife.work.demo.dao.IUserDAO;
import cn.simplelife.work.demo.dao.impl.IUserDAOImpl;
import cn.simplelife.work.demo.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName UserSearchServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/26 9:57
 * @Version 1.0
 */
@WebServlet(value = "/user/search")
public class UserSearchServlet extends HttpServlet {
    private IUserDAO iUserDAO = new IUserDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Long keyword = Long.valueOf(req.getParameter("key"));
        User user = iUserDAO.selectOne(keyword);
        System.out.println(user);
        req.setAttribute("users", user);
        req.getRequestDispatcher("/employee/show.jsp").forward(req,resp);
    }
}
