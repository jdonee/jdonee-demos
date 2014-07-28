/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.jdonee.insight.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.jdonee.insight.account.domain.User;
import com.jdonee.insight.account.dto.UserDTO;
import com.jdonee.insight.account.service.AccountService;
import com.jdonee.insight.framework.service.BaseService;
import com.jdonee.insight.framework.util.commons.Collections3;
import com.jdonee.insight.framework.util.commons.mapper.BeanMapper;
import com.jdonee.insight.framework.util.pagination.Page;
import com.jdonee.insight.task.dao.TaskDao;
import com.jdonee.insight.task.domain.Task;
import com.jdonee.insight.task.dto.TaskDTO;

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

	private AccountService accountService;

	public int deleteByUserId(Long userId) {
		return taskDao.deleteBatchByParams(tableName, ImmutableMap.of("userId", (Object) userId));
	}

	public TaskDTO findTask(Long id) {
		Task task = this.findOneById(id);
		return toDTO(task);
	}

	public List<TaskDTO> findAllTask() {
		List<TaskDTO> taskDtos = Lists.newArrayList();
		List<Task> tasks = this.findAll();
		if (Collections3.isNotEmpty(tasks)) {
			for (Task task : tasks) {
				TaskDTO taskDTO = toDTO(task);
				taskDtos.add(taskDTO);
			}
		}
		return taskDtos;
	}

	public Page<TaskDTO> findTaskPage(Page<TaskDTO> page) {
		int dataCount = this.count(page.getParamsMap());
		page.setDataCount(dataCount);
		List<Task> pageList = this.findPageList(page.getParamsMap(), page.getOffset(), page.getLimit());
		if (Collections3.isNotEmpty(pageList)) {
			List<TaskDTO> taskDtos = Lists.newArrayList();
			for (Task task : pageList) {
				TaskDTO taskDTO = toDTO(task);
				taskDtos.add(taskDTO);
			}
			page.setResult(taskDtos);
		}
		return page;
	}

	private TaskDTO toDTO(final Task task) {
		if (task != null) {
			TaskDTO taskDTO = BeanMapper.map(task, TaskDTO.class);
			User user = accountService.getById(task.getUserId());
			UserDTO userDTO = BeanMapper.map(user, UserDTO.class);
			taskDTO.setUser(userDTO);
			return taskDTO;
		} else {
			return null;
		}
	}

	@Autowired
	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

}
