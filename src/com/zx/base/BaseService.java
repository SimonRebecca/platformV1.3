package com.zx.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhangxin on 2015-07-27.
 */
@SuppressWarnings("all")
public class BaseService<T> {

    @Autowired
    private BaseDao<T> baseDao;

    public T load(Serializable id) {
        return baseDao.load(id);
    }

    public T get(Serializable id) {
        return baseDao.get(id);
    }

    public List<T> getAll() {
        return baseDao.getAll();
    }

    public Serializable save(Object o) {
        return baseDao.save(o);
    }

    public void update(Object o) {
        baseDao.update(o);
    }

    public void delete(Serializable id) {
        baseDao.delete(id);
    }

}
