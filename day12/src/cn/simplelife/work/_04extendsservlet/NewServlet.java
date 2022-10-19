package cn.simplelife.work._04extendsservlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName NewServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/19 15:15
 * @Version 1.0
 */
@WebServlet(value = "/newServlet")
public class NewServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println(request.getHeader("User-Agent"));
        System.out.println("请求处理响应信息");
    }
}
