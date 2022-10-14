package cn.simplelife.homework.demo01.dao.test;

import cn.simplelife.homework.demo01.dao.IEmployeeDAO;
import cn.simplelife.homework.demo01.dao.impl.IEmployeeDAOImpl;
import cn.simplelife.homework.demo01.domain.Employee;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName IEmployeeDAOImplTest
 * @Description
 * @Author simplelife
 * @Date 2022/10/14 11:12
 * @Version 1.0
 */

public class IEmployeeDAOImplTest {
    IEmployeeDAO employeeDAO = new IEmployeeDAOImpl();

    @Test
    public void insert() {
        Employee employee = new Employee(1L, "张三", "123456", 18, "学生");
        employeeDAO.insert(employee);
    }

    @Test
    public void delete() {
        employeeDAO.delete(2L);
    }

    @Test
    public void update() {
        Employee employee = new Employee();
        employee.setId(3L);
        employee.setUsername("李四");
        employeeDAO.update(employee);
    }

    @Test
    public void selectOne() {
        employeeDAO.selectOne(1L);
    }

    @Test
    public void selectAll() {
        employeeDAO.selectAll().forEach(System.out::println);
    }
}