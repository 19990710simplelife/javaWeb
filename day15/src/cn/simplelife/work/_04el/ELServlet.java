package cn.simplelife.work._04el;

import cn.simplelife.work._04el.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ELServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/25 16:22
 * @Version 1.0
 */

@WebServlet(value = "/el")
public class ELServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = new Employee();
        // 设置到作用域中
        req.setAttribute("employee", employee);

        req.getRequestDispatcher("/el/el.jsp").forward(req,resp);
    }
}
