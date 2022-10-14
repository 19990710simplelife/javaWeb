package cn.simplelife.work.dao;

import cn.simplelife.work.domain.User;

import java.util.List;

/**
 * @ClassName IUserDAO
 * @Description
 * @Author simplelife
 * @Date 2022/10/14 15:54
 * @Version 1.0
 */

public interface IUserDAO {
    /**
     * 插入条用户信息
     *
     * @param user 要插入的用户信息
     */
    void insert(User user);

    /**
     * 根据id删除用户信息
     *
     * @param id 要删除的用户id
     */
    void delete(Long id);

    /**
     * 根据id来修改用户信息
     *
     * @param user 要修改的用户id+新的用户信息
     */
    void update(User user);

    /**
     * 根据id查询用户信息
     *
     * @param id 要查询的用户id
     * @return 返回查询的用户对象
     */
    User selectOne(Long id);

    /**
     * 查询所有的用户信息
     *
     * @return 返回用户信息列表
     */
    List<User> selectAll();
}
