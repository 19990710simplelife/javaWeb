package cn.simplelife.work.dao.impl;

import cn.simplelife.work.dao.IUserDAO;
import cn.simplelife.work.domain.User;
import cn.simplelife.work.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @ClassName IuserDAOImpl
 * @Description
 * @Author simplelife
 * @Date 2022/10/15 8:40
 * @Version 1.0
 */

public class IUserDAOImpl implements IUserDAO {
    @Override
    public void insert(User user) {
        SqlSession session = MybatisUtils.getSession();
        session.insert("cn.simplelife.work.dao.IUserDAO.insert", user);
        session.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        SqlSession session = MybatisUtils.getSession();
        session.delete("cn.simplelife.work.dao.IUserDAO.delete", id);
        session.commit();
        session.close();
    }

    @Override
    public void update(User user) {
        SqlSession session = MybatisUtils.getSession();
        session.update("cn.simplelife.work.dao.IUserDAO.update", user);
        session.commit();
        session.close();
    }

    @Override
    public User selectOne(Long id) {
        SqlSession session = MybatisUtils.getSession();
        User user = session.selectOne("cn.simplelife.work.dao.IUserDAO.selectOne", id);
        session.commit();
        session.close();
        return user;
    }

    @Override
    public List<User> selectAll() {
        SqlSession session = MybatisUtils.getSession();
        List<User> userList = session.selectList("cn.simplelife.work.dao.IUserDAO.selectAll");
        session.commit();
        session.close();
        return userList;
    }
}
