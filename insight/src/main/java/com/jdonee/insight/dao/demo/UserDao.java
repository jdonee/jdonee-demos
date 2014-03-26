package com.jdonee.insight.dao.demo;

import com.jdonee.insight.domain.demo.User;
import com.jdonee.insight.util.mybatis.BaseDao;
import com.jdonee.insight.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface UserDao extends BaseDao<User> {

}
