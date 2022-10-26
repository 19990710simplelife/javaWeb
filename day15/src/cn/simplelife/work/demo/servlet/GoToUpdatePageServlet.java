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
 * @ClassName GoToUpdatePageServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/26 11:15
 * @Version 1.0
 */
@WebServlet(value = "/employee/updateUser")
public class GoToUpdatePageServlet extends HttpServlet {
    private IUserDAO iUserDAO = new IUserDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Long id = Long.valueOf(req.getParameter("id"));
        User user = iUserDAO.selectOne(id);
        req.setAttribute("user", user);
        System.out.println(user);
        req.getRequestDispatcher("/employee/updateUser.jsp").forward(req, resp);
    }
}
