package cn.simplelife.work._01servletmapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MappingServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/20 8:52
 * @Version 1.0
 */

public class MappingServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进来了");
    }
}
