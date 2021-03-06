/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.jdonee.insight.account.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.jdonee.framework.service.BaseDTO;

/**
 * 返回XML格式
 * 
 * @author ZengAihui
 * 
 */
@Getter
@Setter
@XmlRootElement(name = "User")
public class UserDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String loginName;
	private String name;
	private String email;

	/**
	 * 重新实现toString()函数方便在日志中打印DTO信息.
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
