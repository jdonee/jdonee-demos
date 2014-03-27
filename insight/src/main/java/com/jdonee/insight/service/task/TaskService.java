/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.jdonee.insight.service.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableMap;
import com.jdonee.insight.dao.demo.TaskDao;
import com.jdonee.insight.domain.demo.Task;
import com.jdonee.insight.service.BaseService;

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

	public int deleteByUserId(Long userId) {
		return taskDao.deleteBatchByParams(tableName, ImmutableMap.of("userId", (Object) userId));
	}

	@Autowired
	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

}
