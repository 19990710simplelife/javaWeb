package cn.simplelife.homework.dao;

import cn.simplelife.work.domain.Account;

import java.math.BigDecimal;

/**
 * @ClassName IAccountDAO
 * @Description
 * @Author simplelife
 * @Date 2022/10/13 21:57
 * @Version 1.0
 */

public interface IAccountDAO {
    /**
     * 转账
     *
     * @param sourceAccount 源账户
     * @param targetAccount 目标账户
     * @param money         转账金额
     */
    void transfer(Account sourceAccount, Account targetAccount, BigDecimal money);
}
