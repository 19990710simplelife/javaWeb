package cn.simplelife.work._03registerservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * @ClassName RegisterServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/20 10:41
 * @Version 1.0
 */
@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码的字符集类型
        // 注意事项，必须写在获取请求参数之前（所有的参数）
        req.setCharacterEncoding("UTF-8");
        // 获取请求参数
        System.out.println("username = " + req.getParameter("username"));
        System.out.println("password = " + req.getParameter("password"));
        System.out.println("gender = " + req.getParameter("gender"));
        System.out.println("hobby = " + Arrays.toString(req.getParameterValues("hobby")));
        System.out.println("address = " + req.getParameter("address"));
        // 框架常用方法
        System.out.println("------------------------------------------------");
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            System.out.println("s = " + s);
            System.out.println(Arrays.toString(req.getParameterValues(s)));
        }
        System.out.println("------------------------------------------------");
        Map<String, String[]> parameterMap = req.getParameterMap();
        parameterMap.forEach((key, value) -> System.out.println(key + "=" + Arrays.toString(value)));
    }
}
