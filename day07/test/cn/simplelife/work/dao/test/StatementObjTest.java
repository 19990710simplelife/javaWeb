package cn.simplelife.work.dao.test;

import cn.simplelife.work.utils.DataSourceUtils;
import org.junit.Test;

import java.sql.*;

/**
 * @ClassName StamentObjTest
 * @Description
 * @Author simplelife
 * @Date 2022/10/14 10:11
 * @Version 1.0
 */

public class StatementObjTest {
    @Test
    public void testStatement() {
        String username = "' OR 1=1 OR '";
        String password = "12345afsf6";
        String sql = "SELECT * FROM `t_user` WHERE username='" + username + "'AND password='" + password + "'";
        System.out.println(sql);
        Connection connection = DataSourceUtils.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (!resultSet.next()) {
                System.out.println("登录失败！");
            } else {
                System.out.println("登录成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataSourceUtils.close(connection, statement, resultSet);
        }
    }

    @Test
    public void testPreStatement() {
        String username = "root";
        String password = "123456";
        String sql = "SELECT * FROM `t_user` WHERE username=? AND password=?";
        Connection connection = DataSourceUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("登录失败！");
            } else {
                System.out.println("登录成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataSourceUtils.close(connection, preparedStatement, resultSet);
        }
    }
}
