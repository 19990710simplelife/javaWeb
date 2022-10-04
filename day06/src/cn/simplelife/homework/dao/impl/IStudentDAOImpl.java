package cn.simplelife.homework.dao.impl;

import cn.simplelife.homework.dao.IStudentDAO;
import cn.simplelife.homework.domain.Student;
import cn.simplelife.homework.utils.JDBCUtils;
import jdk.jshell.spi.SPIResolutionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IStudentDAOImpl
 * @Description
 * @Author simplelife
 * @Date 2022/10/4 17:57
 * @Version 1.0
 */

public class IStudentDAOImpl implements IStudentDAO {

    @Override
    public void insert(Student student) {
        // 1、调用工具类获取连接池对象
        Connection connection = JDBCUtils.getConnection();
        // 2、创建预编译执行语句
        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO student(name,age,email)VALUES (?,?,?)";
            if (connection != null) {
                // 3、获取预编译语句对象
                preparedStatement = connection.prepareStatement(sql);
                // 4、设置？的值
                preparedStatement.setString(1, student.getName());
                preparedStatement.setInt(2, student.getAge());
                preparedStatement.setString(3, student.getEmail());
                // 5、执行sql
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6、调用工具类关闭资源
            JDBCUtils.close(connection, preparedStatement, null);
        }
    }

    @Override
    public void delete(Long id) {
        // 1、调用工具类获取连接
        Connection connection = JDBCUtils.getConnection();
        // 2、创建预编译语句对象
        PreparedStatement preparedStatement = null;
        try {
            if (connection != null) {
                // 3、获取预编译语句对象
                String sql = "DELETE FROM student WHERE id=?";
                preparedStatement = connection.prepareStatement(sql);
                // 4、给？设置值
                preparedStatement.setLong(1, id);
                // 5、执行sql
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, null);
        }
    }

    @Override
    public void update(Student student) {
        // 1、调用工具类获取连接对象
        Connection connection = JDBCUtils.getConnection();
        // 2、创建预编译执行语句对象
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE student SET name=?,age=?,email=? WHERE id=?";
            // 3、获取预编译执行语句对象
            preparedStatement = connection.prepareStatement(sql);
            // 4、给？设置值
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setLong(4, student.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, null);
        }
    }

    @Override
    public Student selectOne(Long id) {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            if (connection != null) {
                String sql = "SELECT * FROM student WHERE id=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, id);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    long resultId = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String email = resultSet.getString("email");
                    return new Student(resultId, name, age, email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public List<Student> selectList() {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Student> list = new ArrayList<>();
        try {
            if (connection != null) {
                String sql = "SELECT * FROM student";
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    long resultId = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String email = resultSet.getString("email");
                    list.add(new Student(resultId, name, age, email));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
        return list;
    }
}
