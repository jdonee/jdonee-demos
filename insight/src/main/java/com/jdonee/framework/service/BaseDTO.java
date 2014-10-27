package com.jdonee.framework.service;

import io.searchbox.annotations.JestId;

/**
 * @author Frank Zeng
 *
 */
public abstract class BaseDTO {

	@JestId
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
