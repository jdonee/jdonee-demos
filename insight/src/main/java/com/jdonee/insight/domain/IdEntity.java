/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.jdonee.insight.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jdonee.insight.util.mybatis.MyBatisTableName;
import com.jdonee.insight.util.mybatis.MyBatisTransient;

/**
 * 统一定义id的entity基类.
 * 
 * @author zengaihui
 */
public abstract class IdEntity {

	protected Long id;

	/**
	 * 保存时写入表名称
	 */
	@MyBatisTransient
	@JsonIgnore
	protected String tableName;

	/**
	 * 保存时写入表(组合)名称
	 */
	@MyBatisTransient
	@JsonIgnore
	protected String tableNames;

	public IdEntity() {
		super();
		MyBatisTableName table = this.getClass().getAnnotation(MyBatisTableName.class);
		this.tableName = table.name();
		this.tableNames = table.names();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
