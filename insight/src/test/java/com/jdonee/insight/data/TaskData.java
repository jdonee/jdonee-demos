/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.jdonee.insight.data;

import java.util.List;

import com.google.common.collect.Lists;
import com.jdonee.insight.domain.demo.Task;

/**
 * Task相关实体测试数据生成.
 * 
 * @author ZengAihui
 * 
 */
public class TaskData {

	public static Task randomTask() {
		Task task = new Task();
		task.setTitle(randomTitle());
		task.setUserId(1L);
		return task;
	}

	public static List<Task> randomTasks(int limit) {
		List<Task> tasks = Lists.newArrayList();
		for (int i = 0; i < limit; i++) {
			tasks.add(randomTask());
		}
		return tasks;
	}

	public static String randomTitle() {
		return RandomData.randomName("Task");
	}
}
