package cn.simplelife.work._03demo.dao;

import cn.simplelife.work._03demo.dao.impl.IUsersDAOImpl;
import cn.simplelife.work._03demo.domain.Users;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName IUsersDAOlTest
 * @Description
 * @Author simplelife
 * @Date 2022/10/28 19:57
 * @Version 1.0
 */

public class IUsersDAOlTest {

    private IUsersDAO iUsersDAO = new IUsersDAOImpl();

    @Test
    public void check() {
        Users users = new Users(null, "lisi", "123456", "123");
        Users check = iUsersDAO.check(users);
        if (check == null) {
            System.out.println("登录失败！");
        } else {
            System.out.println("登录成功！");
        }
    }
}