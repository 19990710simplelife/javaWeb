package cn.simplelife.work.dao;

import cn.simplelife.work.domain.User;

import java.util.List;

/**
 * @ClassName IUserDAO
 * @Description
 * @Author simplelife
 * @Date 2022/10/15 8:36
 * @Version 1.0
 */

public interface IUserDAO {
    /**
     * 添加一个用户
     *
     * @param user 要添加的用户信息
     */
    void insert(User user);

    /**
     * 删除一个用户
     *
     * @param id 要删除的用户的id
     */
    void delete(Long id);

    /**
     * 修改用户信息
     *
     * @param user 要修改的用户的新信息和要修改用户的id
     */
    void update(User user);

    /**
     * 根据id查询一个用户信息
     *
     * @param id 要查询的用户信息的id
     * @return 返回查询到的用户信息
     */
    User selectOne(Long id);

    /**
     * 查询所有的用户信息
     *
     * @return 返回用户信息集合列表
     */
    List<User> selectAll();
}
