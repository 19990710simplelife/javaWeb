package cn.simplelife.test;

import cn.simplelife.dao.IProductDAO;
import cn.simplelife.dao.impl.IProductDAOImpl;
import cn.simplelife.query.ProductQueryByConditionParams;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * @ClassName IProductDAOTest
 * @Description
 * @Author simplelife
 * @Date 2022/11/2 10:44
 * @Version 1.0
 */

public class IProductDAOTest {
    private IProductDAO iProductDAO = new IProductDAOImpl();

    @Test
    public void selectForList() {
        ProductQueryByConditionParams params = new ProductQueryByConditionParams();
        params.setCurrentPage(1);
        params.setPageSize(3);
        params.setProductName("M");
        params.setMinSalePrice(100.0);
        params.setMaxSalePrice(120.0);
        iProductDAO.selectForList(params).forEach(System.out::println);
    }

    @Test
    public void selectForCount() {
        ProductQueryByConditionParams params = new ProductQueryByConditionParams();
        params.setCurrentPage(1);
        params.setPageSize(3);
        params.setProductName("M");
        params.setMinSalePrice(100.0);
        params.setMaxSalePrice(120.0);
        System.out.println(iProductDAO.selectForCount(params));
    }
}