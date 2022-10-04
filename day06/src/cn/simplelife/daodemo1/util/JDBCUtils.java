package cn.simplelife.daodemo1.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName JDBCUtils
 * @Description
 * @Author simplelife
 * @Date 2022/10/4 12:02
 * @Version 1.0
 */

public class JDBCUtils {
    private static Properties properties = new Properties();

    static {
        try {
            // 获取类加载
            ClassLoader aClass = Thread.currentThread().getContextClassLoader();
            // 读取文件
            InputStream resourceAsStream = aClass.getResourceAsStream("db.properties");
            // 加载文件
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
            }
            // 1、加载注册数据库驱动
            Class.forName(properties.getProperty("driverClassName"));
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
