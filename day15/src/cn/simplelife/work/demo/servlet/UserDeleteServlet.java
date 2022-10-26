package cn.simplelife.work.demo.servlet;

import cn.simplelife.work.demo.dao.IUserDAO;
import cn.simplelife.work.demo.dao.impl.IUserDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @ClassName UserDeleteServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/26 9:55
 * @Version 1.0
 */

@WebServlet(value = "/user/delete")
public class UserDeleteServlet extends HttpServlet {
    private IUserDAO iUserDAO = new IUserDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Long id = Long.valueOf(req.getParameter("id"));
        iUserDAO.delete(id);
        resp.sendRedirect("/user/selectAll");
    }
}
