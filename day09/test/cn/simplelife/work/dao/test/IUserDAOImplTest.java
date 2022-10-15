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
 * @Date 2022/10/15 9:14
 * @Version 1.0
 */

public class IUserDAOImplTest {

    private IUserDAO iUserDAO = new IUserDAOImpl();

    @Test
    public void insert() {
        iUserDAO.insert(new User(null, "花花", 15, new BigDecimal("1325")));
    }

    @Test
    public void delete() {
        iUserDAO.delete(3L);
    }

    @Test
    public void update() {

        iUserDAO.update(new User(3L, "花花", 15, new BigDecimal("1325")));
    }

    @Test
    public void selectOne() {
        User user = iUserDAO.selectOne(3L);
        System.out.println("user = " + user);
    }

    @Test
    public void selectAll() {
        iUserDAO.selectAll().forEach(System.out::println);
    }
}