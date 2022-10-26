package cn.simplelife.dao.impl;

import cn.simplelife.dao.IProductDAO;
import cn.simplelife.domain.Product;
import cn.simplelife.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @ClassName IProductDAOImpl
 * @Description
 * @Author simplelife
 * @Date 2022/10/26 20:14
 * @Version 1.0
 */

public class IProductDAOImpl implements IProductDAO {
    @Override
    public void insert(Product product) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        sqlSession.insert("cn.simplelife.dao.IProductDAO.insert", product);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delete(Long id) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        sqlSession.delete("cn.simplelife.dao.IProductDAO.delete", id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(Product product) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        sqlSession.update("cn.simplelife.dao.IProductDAO.update", product);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Product selectOne(Long id) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        Product product = sqlSession.selectOne("cn.simplelife.dao.IProductDAO.selectOne", id);
        sqlSession.commit();
        sqlSession.close();
        return product;
    }

    @Override
    public List<Product> selectAll() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        List<Product> products = sqlSession.selectList("cn.simplelife.dao.IProductDAO.selectAll");
        sqlSession.commit();
        sqlSession.close();
        return products;
    }
}
