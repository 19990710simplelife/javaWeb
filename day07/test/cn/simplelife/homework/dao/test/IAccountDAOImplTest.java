package cn.simplelife.homework.dao.test;

import cn.simplelife.homework.dao.IAccountDAO;
import cn.simplelife.homework.dao.impl.IAccountDAOImpl;
import cn.simplelife.work.domain.Account;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @ClassName IAccountDAOImplTest
 * @Description
 * @Author simplelife
 * @Date 2022/10/13 22:23
 * @Version 1.0
 */

public class IAccountDAOImplTest {

    private IAccountDAO iAccountDAO = new IAccountDAOImpl();

    @Test
    public void transfer() {
        Account sourceAccount = new Account();
        Account targetAccount = new Account();
        sourceAccount.setId(1L);
        targetAccount.setId(2L);
        iAccountDAO.transfer(sourceAccount, targetAccount, new BigDecimal("1000"));
    }
}