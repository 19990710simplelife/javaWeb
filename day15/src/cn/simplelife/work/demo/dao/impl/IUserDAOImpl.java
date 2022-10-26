package cn.simplelife.work.demo.dao.impl;

import cn.simplelife.work.demo.dao.IUserDAO;
import cn.simplelife.work.demo.domain.User;
import cn.simplelife.work.demo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @ClassName IUserDAOImpl
 * @Description
 * @Author simplelife
 * @Date 2022/10/26 9:18
 * @Version 1.0
 */

public class IUserDAOImpl implements IUserDAO {

    @Override
    public void insert(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        sqlSession.insert("cn.simplelife.work.demo.dao.IUserDAO.insert", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delete(Long id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        sqlSession.delete("cn.simplelife.work.demo.dao.IUserDAO.delete", id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        sqlSession.update("cn.simplelife.work.demo.dao.IUserDAO.update", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public User selectOne(Long id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        User user = sqlSession.selectOne("cn.simplelife.work.demo.dao.IUserDAO.selectOne", id);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> selectAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<User> list = sqlSession.selectList("cn.simplelife.work.demo.dao.IUserDAO.selectAll", null);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }
}
