package cn.simplelife.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName App
 * @Description
 * @Author simplelife
 * @Date 2022/10/3 17:22
 * @Version 1.0
 */

public class JdbcInsert {
    public static void main(String[] args) {
        try {
        // 1、加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2、获取数据库连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "XING0710");
            // 3、创建语句对象
            Statement statement=connection.createStatement();
            // 4、执行sql
            String sql="INSERT INTO student(name,age,email)VALUES('张三',18,'15651321@qq.com')";
            statement.execute(sql);
            // 5、释放资源
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
