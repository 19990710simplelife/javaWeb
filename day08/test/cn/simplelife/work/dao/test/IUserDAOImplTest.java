package cn.simplelife.work.dao.test;

import cn.simplelife.work.dao.IUserDAO;
import cn.simplelife.work.dao.impl.IUserDAOImpl;
import cn.simplelife.work.domain.User;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @ClassName IUserDAOImplTest
 * @Description
 * @Author simplelife
 * @Date 2022/10/14 16:10
 * @Version 1.0
 */

public class IUserDAOImplTest {
    private IUserDAO iUserDAO = new IUserDAOImpl();

    @Test
    public void insert() {
        User user = new User(null, "张三", 18, new BigDecimal("90000"));
        iUserDAO.insert(user);
    }

    @Test
    public void delete() {
        iUserDAO.delete(4L);
    }

    @Test
    public void update() {
        User user = new User(3L, "李四", 58, new BigDecimal("100"));
        iUserDAO.update(user);
    }

    @Test
    public void selectOne() {
        User user = iUserDAO.selectOne(3L);
        System.out.println(user);
    }

    @Test
    public void selectAll() {
        iUserDAO.selectAll().forEach(System.out::println);
    }
}