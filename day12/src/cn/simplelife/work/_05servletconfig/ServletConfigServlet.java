package cn.simplelife.work._05servletconfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ServletConfigServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/19 16:04
 * @Version 1.0
 */

public class ServletConfigServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        if ("UTF-8".equals(servletConfig.getInitParameter("encoding"))) {
            System.out.println("你好，世界！");
        } else {
            System.out.println("hello，world！");
        }
    }
}
