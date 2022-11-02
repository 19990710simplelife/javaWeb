package cn.simplelife.web.servlet;


import cn.simplelife.domain.Users;
import cn.simplelife.service.IUserService;
import cn.simplelife.service.impl.IUserServiceImpl;
import cn.simplelife.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
        // 获取验证码
        String randomCode = req.getParameter("randomCode");
        // 获取生成的验证码
        Object code_in_session = req.getSession().getAttribute("CODE_IN_SESSION");
        // 判断验证码是否正确
        if (!(StringUtils.hasLength(randomCode) && randomCode.equals(code_in_session))) {
            req.setAttribute("error", "验证码错误！！!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        // 登录流程
        try {
            Users check = iUserService.login(users);
            HttpSession session = req.getSession();
            session.setAttribute("USERS_IN_SESSION", check);
            // 登录成功后销毁验证码
            session.removeAttribute("CODE_IN_SESSION");
            // 登录成功后判断用户是否记住账号
            String rememberMe = req.getParameter("rememberMe");
            Cookie cookie = new Cookie("username", username);
            if (Boolean.valueOf(rememberMe)) {
                //把用户的信息存入的cookies中,设置存活时间响应给浏览器保存
                cookie.setMaxAge(60 * 60 * 24 * 7);
            } else {
                // 清除浏览器带过来的cookies
                cookie.setMaxAge(0);
            }
            resp.addCookie(cookie);
            // 控制跳转
            resp.sendRedirect("/product");

        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
