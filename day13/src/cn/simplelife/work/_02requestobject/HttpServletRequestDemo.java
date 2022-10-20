package cn.simplelife.work._02requestobject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @ClassName HttpServletRequestDemo
 * @Description
 * @Author simplelife
 * @Date 2022/10/20 9:18
 * @Version 1.0
 */
@WebServlet(value = "/httpServletRequest")
public class HttpServletRequestDemo extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 获取请求行信息
         */
        System.out.println("------------获取请求行信息-------------");
        // 获取请求方式
        System.out.println(req.getMethod());
        // 获取统一资源标识符，代表一个资源的名称
        System.out.println(req.getRequestURI());
        // 获取统一资源标识符，代表一个可以访问的地址
        System.out.println(req.getRequestURL());
        // 获取项目的上下文路径
        System.out.println(req.getContextPath());
        // 获取协议和版本
        System.out.println(req.getProtocol());

        System.out.println("---------------获取请求头------------");
        System.out.println(req.getHeader("User-Agent"));
        System.out.println("---------------获取请求参数------------");
        System.out.println(req.getParameter("username"));
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            System.out.println(parameterNames.nextElement());
        }
    }
}
