package com.jdonee.insight.dao.demo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

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

	/**
	 * @Description: 根据参数列表获取任务列表
	 * 
	 * @param tableNames
	 * @param params
	 * @param rowBounds
	 * @return
	 */
	List<Task> findTaskPageList(@Param(MAPPER_TABLE_NAMES) String tableNames,
			@Param(MAPPER_PARAMS) Map<String, Object> params, RowBounds rowBounds);

	/**
	 * @Description: 根据参数列表统计任务数量
	 * 
	 * @param tableNames
	 * @param params
	 * @return
	 */
	int countTask(@Param(MAPPER_TABLE_NAMES) String tableNames, @Param(MAPPER_PARAMS) Map<String, Object> params);

}
