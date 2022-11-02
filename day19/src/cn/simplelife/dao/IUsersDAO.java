package cn.simplelife.dao;


import cn.simplelife.domain.Users;

/**
 * @ClassName IUsersDAO
 * @Description
 * @Author simplelife
 * @Date 2022/10/28 17:28
 * @Version 1.0
 */

public interface IUsersDAO {
    /**
     * 登录
     *
     * @param users 要登录的用户的信息
     * @return 返回登录的用户
     */
    Users check(Users users);

    /**
     * 通过用户名查询对象
     *
     * @param username 用户名
     * @return 返回用户信息
     */
    Users checkUsersByUsername(String username);
}
