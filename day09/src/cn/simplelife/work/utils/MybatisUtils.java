package cn.simplelife.work.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @ClassName MybatisUtils
 * @Description
 * @Author simplelife
 * @Date 2022/10/15 8:53
 * @Version 1.0
 */

public class MybatisUtils {
    private MybatisUtils() {
    }

    private static SqlSessionFactory factory;

    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库会话连接
     *
     * @return 返回一个数据库会话连接
     */
    public static SqlSession getSession() {
        return factory.openSession();
    }
}
