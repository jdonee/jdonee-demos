/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.jdonee.insight.service.task;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableMap;
import com.jdonee.insight.dao.demo.TaskDao;
import com.jdonee.insight.domain.demo.Task;
import com.jdonee.insight.service.BaseService;
import com.jdonee.insight.service.BusinessLogger;
import com.jdonee.insight.util.mybatis.MyBatisTableName;
import com.jdonee.insight.util.pagination.Page;

/**
 * 作业管理类
 * 
 * @author ZengAihui
 * 
 */
// Spring Bean的标识.
@Component
@Transactional
public class TaskService extends BaseService<Task, Long> {

	private TaskDao taskDao;

	private String tableNames;

	private BusinessLogger businessLogger;

	public TaskService() {
		super();
		MyBatisTableName table = Task.class.getAnnotation(MyBatisTableName.class);
		if (null == table) {
			throw new RuntimeException("类-" + Task.class + ",未用@MyBatisTableName注解标识!!");
		}
		tableNames = table.names();
	}

	public int deleteByUserId(Long userId) {
		return taskDao.deleteBatchByParams(tableName, ImmutableMap.of("userId", (Object) userId));
	}

	public Page<Task> findTaskPage(Page<Task> page) {
		page.setDataCount(taskDao.countTask(tableNames, page.getParamsMap()));
		RowBounds rowBounds = new RowBounds(page.getOffset(), page.getLimit());// 使用RowBounds计算偏移量和偏移总数
		List<Task> pageList = taskDao.findTaskPageList(tableNames, page.getParamsMap(), rowBounds);
		page.setResult(pageList);
		// 业务日志演示
		if (businessLogger != null) {
			businessLogger.log("TASK", "LIST", getCurrentUserName(), null);
		}
		return page;
	}

	@Autowired
	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	@Autowired
	public void setBusinessLogger(BusinessLogger businessLogger) {
		this.businessLogger = businessLogger;
	}

}
