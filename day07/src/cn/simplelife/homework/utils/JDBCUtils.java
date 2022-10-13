package cn.simplelife.homework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName jdbcuTILS
 * @Description
 * @Author simplelife
 * @Date 2022/10/13 22:00
 * @Version 1.0
 */

public class JDBCUtils {
    /**
     * 私有化构造器、防止外部创建对象
     */
    private JDBCUtils() {
    }

    /**
     * 私有化一个properties对象
     */
    private static Properties properties;

    /**
     * 在静态代码块中加载驱动
     */
    static {
        /**
         * 获取数据库配置资源并转为流文件
         */
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
        try {
            if (resourceAsStream != null) {
                properties = new Properties();
                properties.load(resourceAsStream);
                // 加载数据库驱动
                Class.forName(properties.getProperty("driverClassName"));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回一个数据库链接对象
     *
     * @return 返回一个connection对象
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭数据库资源
     *
     * @param connection 数据库链接对象
     * @param statement  数据库会话对象
     * @param resultSet  结果集对象
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
