package com.jdonee.insight.dao.demo;

import com.jdonee.insight.dao.BaseDao;
import com.jdonee.insight.domain.demo.Task;
import com.jdonee.insight.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface TaskDao extends BaseDao<Task> {

}
