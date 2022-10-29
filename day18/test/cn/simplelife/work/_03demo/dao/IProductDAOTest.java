package cn.simplelife.work._03demo.dao;


import cn.simplelife.work._03demo.dao.impl.IProductDAOImpl;
import org.junit.Test;

/**
 * @ClassName IProductDAOTest
 * @Description
 * @Author simplelife
 * @Date 2022/10/28 17:38
 * @Version 1.0
 */

public class IProductDAOTest {
    private IProductDAO iProductDAO = new IProductDAOImpl();

    @Test
    public void insert() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void selectOne() {
    }

    @Test
    public void selectAll() {
        iProductDAO.selectAll().forEach(System.out::println);
    }
}