package cn.simplelife.homework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 与操作数据库相关的工具
 */
public class JDBCUtils {
    /**
     * 私有化构造器防止外部创建对象
     */
    private JDBCUtils() {
    }

    /**
     * 私有化静态的Properties对象
     */
    private static Properties properties;

    static {
        // 1、获取类加载器
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        // 2、获取文件并将其转为输入流
        InputStream resourceAsStream = contextClassLoader.getResourceAsStream("db.properties");
        try {
            // 3、判断输入流是否为空
            if (resourceAsStream != null) {
                // 4、加载流文件
                properties = new Properties();
                properties.load(resourceAsStream);
            }
            // 5、加载数据库驱动
            Class.forName(properties.getProperty("driverClassName"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象
     *
     * @return 返回获取的连接对象
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭资源
     *
     * @param connection 关闭获取的连接
     * @param statement  关闭静态sql执行资源
     * @param resultSet  关闭结果集资源
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
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
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
