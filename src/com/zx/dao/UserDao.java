package com.zx.dao;

import com.zx.base.BaseDao;
import com.zx.pojo.User;
import com.zx.util.Pagination;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.*;

/**
 * Created by zhangxin on 2015-07-27.
 */
@Repository
public class UserDao extends BaseDao<User> {

    public Pagination findUser(User user, int pageNum, int pageSize) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        StringBuilder hql = new StringBuilder("FROM User u WHERE  1 = 1");
        if (user.getUserName() != null) {
            hql.append(" AND u.userName LIKE :userName");
            paramMap.put("userName", "%" + user.getUserName() + "%");
        }
        if (user.getUserAge() != null) {
            hql.append(" AND u.userAge = :userAge");
            paramMap.put("userAge", user.getUserAge());
        }
        if (user.getCreateTimeStartSearch() != null) {
            hql.append(" AND u.createTime >= :createTimeStart");
            paramMap.put("createTimeStart", user.getCreateTimeStartSearch());
        }
        if (user.getCreateTimeEndSearch() != null) {
            hql.append(" AND u.createTime <= :createTimeEnd");
            paramMap.put("createTimeEnd", user.getCreateTimeEndSearch());
        }
        hql.append(" ORDER BY u.createTime DESC");
        return new Pagination(super.find(hql.toString(), paramMap, pageNum, pageSize));
    }
}
