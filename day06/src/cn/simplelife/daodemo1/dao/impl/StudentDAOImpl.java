package cn.simplelife.daodemo1.dao.impl;

import cn.simplelife.daodemo1.dao.IStudentDAO;
import cn.simplelife.daodemo1.domain.Student;
import cn.simplelife.daodemo1.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StudentDaoImpl
 * @Description
 * @Author simplelife
 * @Date 2022/10/3 18:24
 * @Version 1.0
 */

public class StudentDAOImpl implements IStudentDAO {
    @Override
    public void insert(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "INSERT INTO student(name,age,email)VALUES(?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, null);
        }
    }

    @Override
    public void delete(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "DELETE FROM student WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, null);
        }
    }

    @Override
    public void update(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "UPDATE student SET name=?, age=?, email=? WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = new Student();
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT * FROM student WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                long resultId = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                student = new Student(resultId, name, age, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
        return student;
    }

    @Override
    public List<Student> selectList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Student> list = new ArrayList<>();
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT * FROM student";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long resultId = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                Student student = new Student(resultId, name, age, email);
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
        return list;
    }
}
