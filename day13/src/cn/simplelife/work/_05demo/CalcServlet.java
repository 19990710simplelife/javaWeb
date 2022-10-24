package cn.simplelife.work._05demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @ClassName Calc
 * @Description
 * @Author simplelife
 * @Date 2022/10/24 9:47
 * @Version 1.0
 */
@WebServlet(value = "/calc")
public class CalcServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        // 接收请求参数
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String op = req.getParameter("op");
        int result = 0;
        if (hasLength(num1) && hasLength(num2)) {
            Integer integer1 = Integer.valueOf(num1);
            Integer integer2 = Integer.valueOf(num2);
            if ("+".equals(op)) {
                result = integer1 + integer2;
            } else if ("-".equals(op)) {
                result = integer1 - integer2;
            } else if ("*".equals(op)) {
                result = integer1 * integer2;
            } else if ("/".equals(op)) {
                result = integer1 / integer2;
            } else {
                writer.println("输入错误");
            }
        }
        writer.println("<form action='/calc' method='post'>");
        writer.println("<input type='number' name='num1' value=" + num1 + ">");
        writer.println("<select name='op'>");
        writer.println("<option value='+'>+</option>");
        writer.println("<option value='-'>-</option>");
        writer.println("<option value='*'>*</option>");
        writer.println("<option value='/'>/</option>");
        writer.println("</select>");
        writer.println("<input type='number' name='num2' value=" + num2 + ">");
        writer.println("<input type='submit' value='等于'>");
        writer.println("<input type='number' name='result' value=" + result + ">");
        writer.println("</form>");
    }

    private boolean hasLength(String val) {
        return val != null && !"".equals(val.trim());
    }
}
