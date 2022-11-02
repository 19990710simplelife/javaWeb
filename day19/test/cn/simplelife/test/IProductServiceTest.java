package cn.simplelife.test;

import cn.simplelife.query.ProductQueryByConditionParams;
import cn.simplelife.query.QueryObject;
import cn.simplelife.results.PageResult;
import cn.simplelife.service.IProductService;
import cn.simplelife.service.impl.IProductServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName IProductServicelTest
 * @Description
 * @Author simplelife
 * @Date 2022/11/1 11:08
 * @Version 1.0
 */

public class IProductServiceTest {
    private IProductService iProductService = new IProductServiceImpl();

    @Test
    public void query() {
        ProductQueryByConditionParams queryObject = new ProductQueryByConditionParams();
        queryObject.setCurrentPage(1);
        queryObject.setPageSize(3);
        queryObject.setProductName("M");
        queryObject.setMinSalePrice(100.0);
        queryObject.setMaxSalePrice(120.0);
        PageResult query = iProductService.query(queryObject);
        query.getData().forEach(System.out::println);
        System.out.println("当前页 = " + query.getCurrentPage());
        System.out.println("上一页 = " + query.getPrevPage());
        System.out.println("下一页 = " + query.getNextPage());
        System.out.println("总条数 = " + query.getTotalCount());
        System.out.println("总页数 = " + query.getTotalPage());
    }
}