package cn.simplelife.work._05jstl;

import cn.simplelife.work._05jstl.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName EmployeeListServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/25 20:07
 * @Version 1.0
 */

@WebServlet(value = "/emp")
public class EmployeeListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取数据库中员工列表信息
        List<Employee> list = new ArrayList<>();
        Employee employee0 = new Employee("张三", new BigDecimal("8000"));
        Employee employee1 = new Employee("李四", new BigDecimal("20000"));
        Employee employee2 = new Employee("赵六", new BigDecimal("30000"));
        list.add(employee0);
        list.add(employee1);
        list.add(employee2);
        // 2、把列表数据存储到作用域
        req.setAttribute("employeeList", list);
        // 3、跳转到页面展示数据
        req.getRequestDispatcher("/jstl/list.jsp").forward(req, resp);
    }
}
