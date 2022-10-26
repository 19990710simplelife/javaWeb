package cn.simplelife.work.demo.dao;

import cn.simplelife.work.demo.domain.User;

import java.util.List;

/**
 * @ClassName IUserDAO
 * @Description
 * @Author simplelife
 * @Date 2022/10/26 9:18
 * @Version 1.0
 */

public interface IUserDAO {
    /**
     * 添加用户信息
     *
     * @param user 要添加的用户对象
     */
    void insert(User user);

    /**
     * 根据id删除用户信息
     *
     * @param id 要删除的用户id
     */
    void delete(Long id);

    /**
     * 根据id修改用户信息
     *
     * @param user 要修改的用户信息和用户id
     */
    void update(User user);

    /**
     * 根据id查询用户信息
     *
     * @param id 要查询的用户id
     * @return 返回查询到的用户信息
     */
    User selectOne(Long id);


    /**
     * 查询所有用户信息
     *
     * @return 返回查询到的所有用户信息的集合
     */
    List<User> selectAll();
}
