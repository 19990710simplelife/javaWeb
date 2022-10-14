package cn.simplelife.homework.demo01.dao;

import cn.simplelife.homework.demo01.domain.Employee;

import java.util.List;

/**
 * @ClassName IEmployeeDAO
 * @Description
 * @Author simplelife
 * @Date 2022/10/14 10:40
 * @Version 1.0
 */

public interface IEmployeeDAO {
    /**
     * 添加员工对象
     *
     * @param employee 员工对象
     */
    void insert(Employee employee);


    /**
     * 根据id删除员工信息
     *
     * @param id 要删除的员工id
     */
    void delete(Long id);

    /**
     * 修改员工信息
     *
     * @param employee 要修改的员工
     */
    void update(Employee employee);

    /**
     * 根据id查询员工信息
     *
     * @param id 要查询的员工信息id
     * @return 返回查询到的员工对象
     */
    Employee selectOne(Long id);

    /**
     * 查询所有的员工信息
     *
     * @return 返回一个员工信息集合
     */
    List<Employee> selectAll();

    /**
     * 用户登录
     *
     * @param employee 要登录的用户信息
     */
    void login(Employee employee);
}
