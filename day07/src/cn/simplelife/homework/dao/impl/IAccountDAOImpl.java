package cn.simplelife.homework.dao.impl;

import cn.simplelife.homework.dao.IAccountDAO;
import cn.simplelife.homework.utils.JDBCUtils;
import cn.simplelife.work.domain.Account;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName IAccountDAOImpl
 * @Description
 * @Author simplelife
 * @Date 2022/10/13 21:59
 * @Version 1.0
 */

public class IAccountDAOImpl implements IAccountDAO {
    @Override
    public void transfer(Account sourceAccount, Account targetAccount, BigDecimal money) {
        // 1、获取数据库链接、判断源账户是否有足够的金额
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM account WHERE id=? AND balance>1000";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, sourceAccount.getId());
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("账户余额不足请充值！");
                return;
            } else {
                sql = "UPDATE account SET balance=balance-? WHERE id=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setBigDecimal(1, money);
                preparedStatement.setLong(2, sourceAccount.getId());
                preparedStatement.executeUpdate();

                // 账户加钱
                sql = "UPDATE account SET balance=balance+? WHERE id=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setBigDecimal(1, money);
                preparedStatement.setLong(2, targetAccount.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
    }
}
