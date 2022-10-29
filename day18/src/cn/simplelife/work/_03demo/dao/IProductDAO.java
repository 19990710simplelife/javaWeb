package cn.simplelife.work._03demo.dao;

import cn.simplelife.work._03demo.domain.Product;

import java.util.List;

/**
 * @ClassName IProductDAO
 * @Description
 * @Author simplelife
 * @Date 2022/10/28 17:29
 * @Version 1.0
 */

public interface IProductDAO {
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
    Product selectOne(Long id);

    /**
     * 查询所有的商品信息
     *
     * @return 返回查询到的商品集合
     */
    List<Product> selectAll();
}
