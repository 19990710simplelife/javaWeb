package cn.simplelife.work.demo.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @ClassName MybatisUtils
 * @Description
 * @Author simplelife
 * @Date 2022/10/26 9:30
 * @Version 1.0
 */

public class MybatisUtils {
    private MybatisUtils() {
    }

    private static SqlSessionFactory factory = null;

    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        return factory.openSession();
    }
}
