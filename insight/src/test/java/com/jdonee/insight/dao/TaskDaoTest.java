/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.jdonee.insight.dao;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.jdonee.insight.data.TaskData;
import com.jdonee.insight.framework.util.mybatis.MyBatisTableName;
import com.jdonee.insight.framework.util.pagination.Page;
import com.jdonee.insight.junit.BaseJunitSTTestCase;
import com.jdonee.insight.task.dao.TaskDao;
import com.jdonee.insight.task.domain.Task;

public class TaskDaoTest extends BaseJunitSTTestCase<Task> {

	@Autowired
	private TaskDao taskDao;

	@Override
	@Before
	public void setUp() {
		MyBatisTableName table = Task.class.getAnnotation(MyBatisTableName.class);
		if (null == table) {
			throw new RuntimeException("类-" + Task.class + ",未用@MyBatisTableName注解标识!!");
		}
		tableName = table.name();
	}

	@Test
	public void getPage() throws Exception {
		Page<Task> taskPage = new Page();
		Map<String, Object> paramsMap = Maps.newHashMap();
		taskPage.setParamsMap(paramsMap);
		List<Task> tasks = taskDao.findPageList(tableName, taskPage.getParamsMap(), new RowBounds(taskPage.getOffset(),
				taskPage.getLimit()));
		taskPage.setResult(tasks);
		assertThat(taskPage.getResult()).hasSize(5);
		assertThat(taskPage.getResult().get(0).getId()).isEqualTo(1);
		paramsMap.put("id", 99999L);
		tasks = taskDao.findPageList(tableName, taskPage.getParamsMap(),
				new RowBounds(taskPage.getOffset(), taskPage.getLimit()));
		taskPage.setResult(tasks);
		assertThat(taskPage.getResult()).isEmpty();
		assertThat(taskPage.getResult()).isEmpty();
	}

	@Test
	@Rollback(true)
	public void save() {
		int result = taskDao.save(TaskData.randomTask());
		assertThat(result).isEqualTo(1);
	}

	@Test
	@Rollback(true)
	public void deleteBatchByParams() {
		int result = taskDao.deleteBatchByParams(tableName, ImmutableMap.of("userId", (Object) 2));
		assertThat(result).isEqualTo(5);
	}

	@Test
	@Rollback(true)
	public void saveBatch() {
		List<Task> tasks = TaskData.randomTasks(10);
		int result = taskDao.saveBatch(tableName, tasks);
		assertThat(result).isEqualTo(10);
	}

}
