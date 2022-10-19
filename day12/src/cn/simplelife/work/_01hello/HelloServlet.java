package cn.simplelife.work._01hello;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName HelloServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/19 10:47
 * @Version 1.0
 */

public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("处理请求和响应");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
