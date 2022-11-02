package cn.simplelife.service.impl;

import cn.simplelife.dao.IProductDAO;
import cn.simplelife.dao.impl.IProductDAOImpl;
import cn.simplelife.domain.Product;
import cn.simplelife.query.QueryObject;
import cn.simplelife.results.PageResult;
import cn.simplelife.service.IProductService;

import java.util.Collections;
import java.util.List;

/**
 * @ClassName IProductServiceImpl
 * @Description
 * @Author simplelife
 * @Date 2022/11/1 10:45
 * @Version 1.0
 */

public class IProductServiceImpl implements IProductService {
    private IProductDAO dao = new IProductDAOImpl();
    @Override
    public void insert(Product product) {
        dao.insert(product);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public void update(Product product) {
        dao.update(product);
    }

    @Override
    public Product selectOnes(Long id) {

        Product product = dao.selectOnes(id);
        return product;
    }

    @Override
    public List<Product> selectAlls() {
        List<Product> products = dao.selectAlls();
        return products;
    }

    @Override
    public PageResult query(QueryObject queryObject) {
        // 1、查询满足条件的总数
        int totalCount = dao.selectForCount(queryObject);
        // 2、获取满足条件的结果条数
        if (totalCount == 0) {
            return new PageResult(queryObject.getCurrentPage(), queryObject.getPageSize());
        }
        List<Product> products = dao.selectForList(queryObject);
        // 3、封装为对象返回给servlet
        return new PageResult(queryObject.getCurrentPage(), queryObject.getPageSize(), products, totalCount);
    }
}
