package cn.simplelife.work._02cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName CookiesListServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/27 11:02
 * @Version 1.0
 */

@WebServlet(value = "/cookies/list")
public class CookiesListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = null;
        // 获取浏览器响应的cookies
        Cookie[] cookies = req.getCookies();
        // 便利cookies获取浏览器响应的数据
        for (Cookie cookie : cookies) {
            if ("username".equals(cookie.getName())) {
                username = cookie.getValue();
                // 修改cookies中的数据
                //cookie.setValue("root");
                // 重新响应cookies
                //resp.addCookie(cookie);
            }
        }
//        Cookie cookie = new Cookie("username", "adminroot");
//        resp.addCookie(cookie);

        req.setAttribute("username", username);
        List<String> list = Arrays.asList("邮件一", "邮件二", "邮件三");
        req.setAttribute("list", list);
        req.getRequestDispatcher("/WEB-INF/cookies/list.jsp").forward(req, resp);
    }
}
