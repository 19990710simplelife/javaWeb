package cn.simplelife.service;

import cn.simplelife.domain.Product;
import cn.simplelife.query.QueryObject;
import cn.simplelife.results.PageResult;

import java.util.List;

/**
 * @ClassName IProductService
 * @Description
 * @Author simplelife
 * @Date 2022/11/1 10:43
 * @Version 1.0
 */

public interface IProductService {
    /**
     * 添加商品信息
     *
     * @param product 要插入的商品信息
     */
    void insert(Product product);

    /**
     * 根据商品信息删除商品
     *
     * @param id 要删除的商品信息
     */
    void delete(Long id);

    /**
     * 根据id修改商品信息
     *
     * @param product 要修改的商品信息和商品id
     */
    void update(Product product);

    /**
     * 根据id查询商品信息
     *
     * @param id 要查询的商品信息
     * @return 返回查询到的商品信息
     */
    Product selectOnes(Long id);

    /**
     * 查询所有的商品信息
     *
     * @return 返回查询到的商品集合
     */
    List<Product> selectAlls();

    /**
     * 分页查询
     *
     * @param queryObject 用户携带的查询参数
     * @return 当前页的数据和分页数据
     */
    PageResult query(QueryObject queryObject);
}
