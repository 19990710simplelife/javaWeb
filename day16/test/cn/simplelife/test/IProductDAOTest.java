package cn.simplelife.test;

import cn.simplelife.dao.IProductDAO;
import cn.simplelife.dao.impl.IProductDAOImpl;
import cn.simplelife.domain.Product;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName IProductDAOTest
 * @Description
 * @Author simplelife
 * @Date 2022/10/26 20:16
 * @Version 1.0
 */

public class IProductDAOTest {

    private IProductDAO iProductDAO = new IProductDAOImpl();

    @Test
    public void insert() {
        Product product = new Product(null, "三星垃圾", 3L, 45.0, "三星", "显示屏", 0.5, 55.0);
        iProductDAO.insert(product);
    }

    @Test
    public void delete() {
        iProductDAO.delete(21L);
    }

    @Test
    public void update() {
        Product product = new Product(23L, "三星11垃圾", 3L, 45.0, "三星", "显示屏", 0.5, 55.0);
        iProductDAO.update(product);
    }

    @Test
    public void selectOne() {
        Product product = iProductDAO.selectOne(23L);
        System.out.println(product);
    }

    @Test
    public void selectAll() {
        List<Product> products = iProductDAO.selectAll();
        products.forEach(System.out::println);
    }
}