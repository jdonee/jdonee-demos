/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.jdonee.insight.dao;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Maps;
import com.jdonee.framework.util.pagehelper.PageHelper;
import com.jdonee.framework.util.pagehelper.PageInfo;
import com.jdonee.insight.account.dao.UserDao;
import com.jdonee.insight.account.domain.User;
import com.jdonee.insight.junit.BaseJunitSTTestCase;

public class UserDaoTest extends BaseJunitSTTestCase<User> {

	@Autowired
	private UserDao userDao;

	@Test
	public void getPage() throws Exception {
		Map<String, Object> paramsMap = Maps.newHashMap();
		PageHelper.startPage(1, 10);
		List<User> users = userDao.findListByParams(tableName, paramsMap);
		PageInfo<User> userPage = new PageInfo(users);
		assertThat(userPage.getList()).hasSize(2);
		assertThat(userPage.getList().get(0).getId()).isEqualTo(1);
		paramsMap.put("id", 99999L);
		PageHelper.startPage(1, 10);
		users = userDao.findListByParams(tableName, paramsMap);
		userPage = new PageInfo(users);
		assertThat(userPage.getList()).hasSize(0);
	}

	@Test
	public void getById() throws Exception {
		User user = userDao.findOneById(tableName, 1L);
		assertThat(user.getId()).isEqualTo(1);
	}

}
