package cn.simplelife.work.dao.test;

import cn.simplelife.work.dao.IAccountDAO;
import cn.simplelife.work.dao.Impl.IAccountDAOImpl;
import cn.simplelife.work.domain.Account;
import cn.simplelife.work.utils.DataSourceUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * @ClassName IAccountDAOImplTest
 * @Description
 * @Author simplelife
 * @Date 2022/10/4 21:15
 * @Version 1.0
 */

public class IAccountDAOImplTest {
    private IAccountDAO accountDAO = new IAccountDAOImpl();

    @Test
    public void transfer() {
        Account sourceAccount = new Account();
        Account targetAccount = new Account();
        sourceAccount.setId(1L);
        targetAccount.setId(2L);
        accountDAO.transfer(sourceAccount, targetAccount, new BigDecimal("1000"));
    }

    @Test
    public void testDruidDatasource() {
        Connection connection = DataSourceUtils.getConnection();
        System.out.println("connection = " + connection);
    }
}