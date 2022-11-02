package cn.simplelife.dao;


import cn.simplelife.domain.Product;
import cn.simplelife.query.QueryObject;

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
    Product selectOnes(Long id);

    /**
     * 查询所有的商品信息
     *
     * @return 返回查询到的商品集合
     */
    List<Product> selectAlls();

    /**
     * 根据条件查询当前页数据
     *
     * @param queryObject 查询对象条件
     * @return 返回满足条件的数据集合
     */
    List<Product> selectForList(QueryObject queryObject);

    /**
     * 查询满足条件的总数
     *
     * @return 返回数据的总条数
     */
    int selectForCount();
}
