package cn.simplelife.work._04extendsservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName HttpServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/19 15:47
 * @Version 1.0
 */
@WebServlet(value = "/httpServlet")
public class HttpServlet extends MyHttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getHeader("User-Agent"));
    }
}
