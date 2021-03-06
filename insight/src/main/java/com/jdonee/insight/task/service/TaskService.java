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
import com.jdonee.framework.service.BaseService;
import com.jdonee.framework.util.commons.Collections3;
import com.jdonee.framework.util.commons.mapper.BeanMapper;
import com.jdonee.framework.util.pagehelper.Page;
import com.jdonee.framework.util.pagehelper.PageHelper;
import com.jdonee.framework.util.pagehelper.PageInfo;
import com.jdonee.framework.util.pagehelper.QuerySearch;
import com.jdonee.insight.account.domain.User;
import com.jdonee.insight.account.dto.UserDTO;
import com.jdonee.insight.account.service.AccountService;
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

	public PageInfo<TaskDTO> findTaskPage(QuerySearch querySearch) {
		PageHelper.startPage(querySearch.getPageNumber(), querySearch.getPageSize());
		Page<Task> pageList = (Page) this.findSortListByParams(querySearch.getSearchParams(),
				querySearch.generateSorts(querySearch.getSortParams()));
		if (Collections3.isNotEmpty(pageList.getResult())) {
			Page<TaskDTO> taskDtos = BeanMapper.map(pageList, Page.class);
			taskDtos.setEndRow(pageList.getEndRow());
			taskDtos.setPages(pageList.getPages());
			taskDtos.getResult().clear();
			for (Task task : pageList.getResult()) {
				TaskDTO taskDTO = toDTO(task);
				taskDtos.add(taskDTO);
			}
			return new PageInfo(taskDtos);
		} else {
			return new PageInfo();
		}
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
