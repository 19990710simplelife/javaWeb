package cn.simplelife.dao.impl;

import cn.simplelife.dao.IUsersDAO;
import cn.simplelife.domain.Users;
import cn.simplelife.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @ClassName IUsersDAOImpl
 * @Description
 * @Author simplelife
 * @Date 2022/10/28 19:55
 * @Version 1.0
 */

public class IUsersDAOImpl implements IUsersDAO {

    @Override
    public Users check(Users users) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        Users user = sqlSession.selectOne("cn.simplelife.dao.IUsersDAO.check", users);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }

    @Override
    public Users checkUsersByUsername(String username) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        Users user = sqlSession.selectOne("cn.simplelife.dao.IUsersDAO.checkUsersByUsername", username);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }
}
