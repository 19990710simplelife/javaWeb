package cn.simplelife.work._03demo.dao.impl;

import cn.simplelife.work._03demo.dao.IProductDAO;
import cn.simplelife.work._03demo.domain.Product;
import cn.simplelife.work._03demo.uitils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @ClassName IProductDAOImpl
 * @Description
 * @Author simplelife
 * @Date 2022/10/28 17:34
 * @Version 1.0
 */

public class IProductDAOImpl implements IProductDAO {
    @Override
    public void insert(Product product) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        sqlSession.insert("cn.simplelife.work._03demo.dao.IProductDAO.insert", product);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delete(Long id) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        sqlSession.delete("cn.simplelife.work._03demo.dao.IProductDAO.delete", id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(Product product) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        sqlSession.update("cn.simplelife.work._03demo.dao.IProductDAO.update", product);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Product selectOne(Long id) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        Product product = sqlSession.selectOne("cn.simplelife.work._03demo.dao.IProductDAO.selectOne", id);
        sqlSession.commit();
        sqlSession.close();
        return product;
    }

    @Override
    public List<Product> selectAll() {
        SqlSession sqlSession = MyBatisUtils.openSession();
        List<Product> list = sqlSession.selectList("cn.simplelife.work._03demo.dao.IProductDAO.selectAll");
        sqlSession.commit();
        sqlSession.close();
        return list;
    }
}
