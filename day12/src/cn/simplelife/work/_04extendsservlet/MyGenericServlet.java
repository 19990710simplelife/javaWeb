package cn.simplelife.work._04extendsservlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName ExtendServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/19 15:10
 * @Version 1.0
 */

public class MyGenericServlet implements Servlet {
    ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
    }
}
