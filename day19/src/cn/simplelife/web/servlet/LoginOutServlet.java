package cn.simplelife.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName LoginOutServlet
 * @Description
 * @Author simplelife
 * @Date 2022/11/2 16:07
 * @Version 1.0
 */
@WebServlet(value = "/loginOut")
public class LoginOutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取session中的用户信息
//        HttpSession session = req.getSession();
//        Object user_in_session = session.getAttribute("USER_IN_SESSION");
//        session.removeAttribute((String) user_in_session);
        req.getSession().invalidate();//销毁session
//        req.getSession().removeAttribute("USERS_IN_SESSION");
        resp.sendRedirect("/login.jsp");
    }
}
