package cn.simplelife.work._04response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName HttpServletResponseServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/24 9:26
 * @Version 1.0
 */
@WebServlet(value = "/response")
public class HttpServletResponseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 使用response对象给浏览器响应信息
        // 1、使用response中的getOutputStream()获取输出流
//        ServletOutputStream outputStream = resp.getOutputStream();
        // 2、处理响应中中文乱码问题
        resp.setCharacterEncoding("UTF-8");
        // 3、设置响应头信息，来指明响应数据的MIME类型
        resp.setContentType("text/html;charset=UTF-8");
        // 4、向往书写信息
        PrintWriter writer = resp.getWriter();
        writer.println("<h1 style='color:red'>你好世界！</h1>");
        writer.println("<span>你还是猪啊？</span>");
    }
}
