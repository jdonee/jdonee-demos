package com.jdonee.insight.account.dao;

import com.jdonee.insight.account.domain.User;
import com.jdonee.insight.framework.dao.BaseDao;
import com.jdonee.insight.framework.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface UserDao extends BaseDao<User, Long> {

}
