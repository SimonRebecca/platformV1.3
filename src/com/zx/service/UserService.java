package com.zx.service;

import com.zx.base.BaseService;
import com.zx.dao.UserDao;
import com.zx.pojo.User;
import com.zx.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxin on 2015-07-27.
 */
@Service
public class UserService extends BaseService<User> {

    @Autowired
    private UserDao userDao;

    public Pagination findUser(User user, int pageNum, int pageSize) {
        return userDao.findUser(user, pageNum, pageSize);
    }
}
