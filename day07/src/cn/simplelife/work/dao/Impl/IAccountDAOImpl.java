package cn.simplelife.work.dao.Impl;

import cn.simplelife.work.dao.IAccountDAO;
import cn.simplelife.work.domain.Account;
import cn.simplelife.work.utils.JDBCUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName IAccountDAOImpl
 * @Description
 * @Author simplelife
 * @Date 2022/10/4 20:43
 * @Version 1.0
 */

public class IAccountDAOImpl implements IAccountDAO {
    @Override
    public void transfer(Account sourceAccount, Account targetAccount, BigDecimal money) {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            if (connection != null) {
                // 1、判断是否有足够的余额
                String sql = "SELECT * FROM account WHERE id=? AND balance>=1000";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, sourceAccount.getId());
                resultSet = preparedStatement.executeQuery();
                // 2、余额不足开启提醒
                if (!resultSet.next()) {
                    System.out.println("账户余额不足！请充值！");
                    return;
                }
                // 3、余额充足开始转账
                sql = "UPDATE account SET balance = balance-? WHERE id=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setBigDecimal(1, money);
                preparedStatement.setLong(2, sourceAccount.getId());
                preparedStatement.executeUpdate();
                // 模拟停电
                int i = 10 / 0;
                // 4、账户价钱
                sql = "UPDATE account SET balance = balance+? WHERE id=?";
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
