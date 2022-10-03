package cn.simplelife.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName JdbcDelete
 * @Description
 * @Author simplelife
 * @Date 2022/10/3 17:58
 * @Version 1.0
 */

public class JdbcDelete {
    public static void main(String[] args) {
        try {
        //1、加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2、获取数据库连接对象
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "XING0710");
            // 3、创建静态sql
            Statement statement = connection.createStatement();
            // 4、执行sql
            String sql="DELETE FROM student where id = 3";
            statement.execute(sql);
            // 5、释放资源
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
