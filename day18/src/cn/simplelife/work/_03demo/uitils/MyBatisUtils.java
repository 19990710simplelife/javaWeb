package cn.simplelife.work._03demo.uitils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @ClassName MyBatisUtils
 * @Description
 * @Author simplelife
 * @Date 2022/10/28 17:21
 * @Version 1.0
 */

public class MyBatisUtils {
    private static SqlSessionFactory factory;

    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession openSession() {
        return factory.openSession();
    }
}
