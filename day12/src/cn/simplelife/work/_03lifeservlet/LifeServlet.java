package cn.simplelife.work._03lifeservlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @ClassName LifeServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/19 11:20
 * @Version 1.0
 */
@WebServlet(value = "/lifeServlet")
public class LifeServlet implements Servlet {

    public LifeServlet() {
        System.out.println("创建对象");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化操作");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("处理响应和请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁操作");
    }
}
