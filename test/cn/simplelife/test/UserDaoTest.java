package cn.simplelife.test;

import cn.simplelife.junit.UserDaoImpl;
import org.junit.Test;

/**
 * @ClassName UserDaoTest
 * @Description
 * @Author simplelife
 * @Date 2022/8/30 11:26
 * @Version 1.0
 */

public class UserDaoTest {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void testAdd() {
        System.out.println(userDao.add(12, 11));
    }

    @Test
    public void testDelete() {
        userDao.delete(1);
    }
}
