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
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.google.common.collect.Maps;
import com.jdonee.insight.dao.demo.TaskDao;
import com.jdonee.insight.data.TaskData;
import com.jdonee.insight.domain.demo.Task;
import com.jdonee.insight.junit.BaseJunitSTTestCase;
import com.jdonee.insight.util.pagination.Page;

public class TaskDaoTest extends BaseJunitSTTestCase<Task> {

	@Autowired
	private TaskDao taskDao;

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

	@Rollback(true)
	@Test
	public void save() {
		int result = taskDao.save(TaskData.randomTask());
		assertThat(result).equals(1);
	}
}
