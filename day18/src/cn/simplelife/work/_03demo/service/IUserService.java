package cn.simplelife.work._03demo.service;

import cn.simplelife.work._03demo.domain.Users;

/**
 * @ClassName IUserService
 * @Description
 * @Author simplelife
 * @Date 2022/10/29 10:51
 * @Version 1.0
 */

public interface IUserService {
    /**
     * 登录
     *
     * @param users 要登录的用户的信息
     * @return 返回登录的用户
     */
    Users login(Users users);
}
