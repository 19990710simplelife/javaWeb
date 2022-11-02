package cn.simplelife.test;

import cn.simplelife.dao.IProductDAO;
import cn.simplelife.dao.impl.IProductDAOImpl;
import cn.simplelife.query.QueryObject;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName IProductTest
 * @Description
 * @Author simplelife
 * @Date 2022/11/1 9:50
 * @Version 1.0
 */

public class IProductTest {

    private IProductDAO iProductDAO = new IProductDAOImpl();

    @Test
    public void selectForList() {
        QueryObject queryObject = new QueryObject(1, 2);
        iProductDAO.selectForList(queryObject).forEach(System.out::println);
    }

    @Test
    public void selectForCount() {
        System.out.println(iProductDAO.selectForCount());
    }
}