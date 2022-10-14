package cn.simplelife.work.datasources;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @ClassName DataSourceTest
 * @Description
 * @Author simplelife
 * @Date 2022/10/14 9:23
 * @Version 1.0
 */

public class DataSourceTest {
    public static void main(String[] args) {
        testDataSource();
    }

    public static void testDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/student");
        dataSource.setUsername("root");
        dataSource.setPassword("XING0710");
        dataSource.setInitialSize(5);
        try {
            DruidPooledConnection connection = dataSource.getConnection();
            System.out.println("connection = " + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
