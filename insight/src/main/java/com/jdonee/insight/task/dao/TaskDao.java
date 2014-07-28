package com.jdonee.insight.task.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jdonee.insight.framework.dao.BaseDao;
import com.jdonee.insight.task.domain.Task;

@com.jdonee.insight.framework.util.mybatis.MyBatisRepository
public interface TaskDao extends BaseDao<Task, Long> {

	/**
	 * @Description: 根据参数列表批量删除任务
	 * @param tableName
	 * @param params
	 * @return
	 */
	int deleteBatchByParams(@Param(MAPPER_TABLE_NAME) String tableName, @Param(MAPPER_PARAMS) Map<String, Object> params);

}
