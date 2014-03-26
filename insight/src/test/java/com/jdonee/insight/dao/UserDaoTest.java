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

import com.google.common.collect.Maps;
import com.jdonee.insight.dao.demo.UserDao;
import com.jdonee.insight.domain.demo.User;
import com.jdonee.insight.junit.BaseJunitSTTestCase;
import com.jdonee.insight.util.pagination.Page;

public class UserDaoTest extends BaseJunitSTTestCase<User> {

	@Autowired
	private UserDao userDao;

	@Test
	public void getPage() throws Exception {
		Page<User> userPage = new Page();
		Map<String, Object> paramsMap = Maps.newHashMap();
		userPage.setParamsMap(paramsMap);
		List<User> users = userDao.findPageList(tableName, userPage.getParamsMap(), new RowBounds(userPage.getOffset(),
				userPage.getLimit()));
		userPage.setResult(users);
		assertThat(userPage.getResult()).hasSize(2);
		assertThat(userPage.getResult().get(0).getId()).isEqualTo(1);
		paramsMap.put("id", 99999L);
		users = userDao.findPageList(tableName, userPage.getParamsMap(),
				new RowBounds(userPage.getOffset(), userPage.getLimit()));
		userPage.setResult(users);
		assertThat(userPage.getResult()).isEmpty();
		assertThat(userPage.getResult()).isEmpty();
	}

	@Test
	public void getById() throws Exception {
		User user = userDao.findOneById(tableName, 1L);
		assertThat(user.getId()).isEqualTo(1);
	}

}
