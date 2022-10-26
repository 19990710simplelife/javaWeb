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
import java.math.BigDecimal;

/**
 * @ClassName UserUpdateServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/26 9:56
 * @Version 1.0
 */
@WebServlet(value = "/user/update")
public class UserUpdateServlet extends HttpServlet {
    private IUserDAO iUserDAO = new IUserDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Long id = Long.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        Integer age = Integer.valueOf(req.getParameter("age"));
        BigDecimal salary = new BigDecimal(req.getParameter("salary"));
        User user = new User(id, name, age, salary);
        iUserDAO.update(user);
        resp.sendRedirect("/user/selectAll");
    }
}
