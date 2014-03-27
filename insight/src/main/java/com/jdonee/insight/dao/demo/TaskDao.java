package com.jdonee.insight.dao.demo;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jdonee.insight.dao.BaseDao;
import com.jdonee.insight.domain.demo.Task;
import com.jdonee.insight.util.mybatis.MyBatisRepository;

@MyBatisRepository
public interface TaskDao extends BaseDao<Task, Long> {

	/**
	 * @Description: 根据参数列表批量删除任务
	 * @param tableName
	 * @param params
	 * @return
	 */
	int deleteBatchByParams(@Param(MAPPER_TABLE_NAME) String tableName, @Param(MAPPER_PARAMS) Map<String, Object> params);

}
