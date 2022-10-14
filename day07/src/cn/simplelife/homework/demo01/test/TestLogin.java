package cn.simplelife.homework.demo01.test;

import cn.simplelife.homework.demo01.dao.IEmployeeDAO;
import cn.simplelife.homework.demo01.dao.impl.IEmployeeDAOImpl;
import cn.simplelife.homework.demo01.domain.Employee;

import java.util.Scanner;

/**
 * @ClassName main
 * @Description
 * @Author simplelife
 * @Date 2022/10/14 14:28
 * @Version 1.0
 */

public class TestLogin {
    public static void main(String[] args) {
        IEmployeeDAO dao = new IEmployeeDAOImpl();
        Employee employee = new Employee();
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        employee.setUsername(username);
        employee.setPassword(password);
        dao.login(employee);
    }
}
