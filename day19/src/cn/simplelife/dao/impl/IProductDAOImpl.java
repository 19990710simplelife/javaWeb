package cn.simplelife.dao.impl;


import cn.simplelife.dao.IProductDAO;
import cn.simplelife.domain.Product;
import cn.simplelife.query.QueryObject;
import cn.simplelife.utils.MyBatisUtils;
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
        sqlSession.insert("cn.simplelife.dao.IProductDAO.insert", product);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delete(Long id) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        sqlSession.delete("cn.simplelife.dao.IProductDAO.delete", id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(Product product) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        sqlSession.update("cn.simplelife.dao.IProductDAO.update", product);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Product selectOnes(Long id) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        Product product = sqlSession.selectOne("cn.simplelife.dao.IProductDAO.selectOnes", id);
        sqlSession.commit();
        sqlSession.close();
        return product;
    }


    @Override
    public List<Product> selectAlls() {
        SqlSession sqlSession = MyBatisUtils.openSession();
        List<Product> list = sqlSession.selectList("cn.simplelife.dao.IProductDAO.selectAlls");
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public List<Product> selectForList(QueryObject queryObject) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        List<Product> list = sqlSession.selectList("cn.simplelife.dao.IProductDAO.selectForList",queryObject);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public int selectForCount() {
        SqlSession sqlSession = MyBatisUtils.openSession();
        int totalCount = sqlSession.selectOne("cn.simplelife.dao.IProductDAO.selectForCount");
        sqlSession.commit();
        sqlSession.close();
        return totalCount;
    }
}
