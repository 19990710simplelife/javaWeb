package cn.simplelife.homework.demo01.dao.impl;

import cn.simplelife.homework.demo01.dao.IEmployeeDAO;
import cn.simplelife.homework.demo01.domain.Employee;
import cn.simplelife.homework.demo01.utils.DruidDatasourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IEmployeeDAOImpl
 * @Description
 * @Author simplelife
 * @Date 2022/10/14 10:41
 * @Version 1.0
 */

public class IEmployeeDAOImpl implements IEmployeeDAO {
    @Override
    public void insert(Employee employee) {
        Connection connection = DruidDatasourceUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO t_employee(username,password,age,job)VALUES (?,?,?,?)";
            if (connection != null) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, employee.getUsername());
                preparedStatement.setString(2, employee.getPassword());
                preparedStatement.setInt(3, employee.getAge());
                preparedStatement.setString(4, employee.getJob());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidDatasourceUtils.close(connection, preparedStatement, null);
        }
    }

    @Override
    public void delete(Long id) {
        Connection connection = DruidDatasourceUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            if (connection != null) {
                String sql = "DELETE FROM t_employee WHERE id=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, id);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidDatasourceUtils.close(connection, preparedStatement, null);
        }
    }

    @Override
    public void update(Employee employee) {
        Connection connection = DruidDatasourceUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            if (connection != null) {
                String sql = "UPDATE t_employee SET username=?,password=?,age=?,job=? WHERE id=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, employee.getUsername());
                preparedStatement.setString(2, employee.getPassword());
                preparedStatement.setInt(3, employee.getAge());
                preparedStatement.setString(4, employee.getJob());
                preparedStatement.setLong(5, employee.getId());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidDatasourceUtils.close(connection, preparedStatement, null);
        }
    }

    @Override
    public Employee selectOne(Long id) {
        Connection connection = DruidDatasourceUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Employee employee = null;
        try {
            if (connection != null) {
                String sql = "SELECT * FROM t_employee WHERE id=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, id);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    long id1 = resultSet.getLong("id");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    int age = resultSet.getInt("age");
                    String job = resultSet.getString("job");
                    employee = new Employee(id1, username, password, age, job);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidDatasourceUtils.close(connection, preparedStatement, null);
        }
        return employee;
    }

    @Override
    public List<Employee> selectAll() {
        Connection connection = DruidDatasourceUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Employee> employeeList = new ArrayList<>();
        try {
            if (connection != null) {
                String sql = "SELECT * FROM t_employee";
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    long id1 = resultSet.getLong("id");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    int age = resultSet.getInt("age");
                    String job = resultSet.getString("job");
                    Employee employee = new Employee(id1, username, password, age, job);
                    employeeList.add(employee);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidDatasourceUtils.close(connection, preparedStatement, null);
        }
        return employeeList;
    }
}
