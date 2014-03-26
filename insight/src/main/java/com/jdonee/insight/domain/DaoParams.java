package com.jdonee.insight.domain;

import java.io.Serializable;
import java.util.Map;

public class DaoParams implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String tableName;

	private String tableNames;

	private Map<String, Object> params;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableNames() {
		return tableNames;
	}

	public void setTableNames(String tableNames) {
		this.tableNames = tableNames;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
