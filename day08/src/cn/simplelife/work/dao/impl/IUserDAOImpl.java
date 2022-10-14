package cn.simplelife.work.dao.impl;

import cn.simplelife.work.dao.IUserDAO;
import cn.simplelife.work.domain.User;
import cn.simplelife.work.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IUserDAOImpl
 * @Description
 * @Author simplelife
 * @Date 2022/10/14 15:59
 * @Version 1.0
 */

public class IUserDAOImpl implements IUserDAO {
    @Override
    public void insert(User user) {
        SqlSession session = MyBatisUtils.getSqlSession();
        // 3、执行操作
        session.insert("cn.simplelife.work.mapper.UserMapper.insert", user);
        // 4、提交事务
        session.commit();
        // 5、释放资源
        session.close();
    }

    @Override
    public void delete(Long id) {
        try {
            // 1、加载配置文件，获取SqlSessionFactory对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            // 2、获取sqlSession会话对象
            SqlSession sqlSession = factory.openSession();
            // 3、执行语句
            sqlSession.delete("cn.simplelife.work.mapper.UserMapper.delete", id);
            // 4、提交事务
            sqlSession.commit();
            // 5、释放资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try {
            // 1、加载配置文件及获取factory对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            // 2、获取sqlSession会话对象
            SqlSession sqlSession = factory.openSession();
            // 4、执行操作
            sqlSession.update("cn.simplelife.work.mapper.UserMapper.update", user);
            // 5、提交事务
            sqlSession.commit();
            // 6、释放资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User selectOne(Long id) {
        User user = null;
        try {
            // 1、加载配置文件
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            // 2、获取sqlSession会话对象
            SqlSession sqlSession = factory.openSession();
            // 3、执行操作
            user = sqlSession.selectOne("cn.simplelife.work.mapper.UserMapper.selectOne", id);
            // 4、提交事务
            sqlSession.commit();
            // 5、释放资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAll() {
        // 2、获取sqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 3、执行语句
        List<User> userList = sqlSession.selectList("cn.simplelife.work.mapper.UserMapper.selectAll");
        // 4、提交事务
        sqlSession.commit();
        // 5、释放资源
        sqlSession.close();
        return userList;
    }
}
