package cn.simplelife.service.impl;


import cn.simplelife.dao.IUsersDAO;
import cn.simplelife.dao.impl.IUsersDAOImpl;
import cn.simplelife.domain.Users;
import cn.simplelife.service.IUserService;

/**
 * @ClassName IUserServiceImpl
 * @Description
 * @Author simplelife
 * @Date 2022/10/29 10:51
 * @Version 1.0
 */

public class IUserServiceImpl implements IUserService {
    // 引入dao
    private IUsersDAO iUsersDAO = new IUsersDAOImpl();

    @Override
    public Users login(Users users) {
        Users check = iUsersDAO.checkUsersByUsername(users.getUsername());
        if (check == null) {
            throw new RuntimeException("亲，用户名错误！");
        }
        if (!users.getPassword().equals(check.getPassword())){
            throw new RuntimeException("亲，密码错误！");
        }
        return check;
    }

}