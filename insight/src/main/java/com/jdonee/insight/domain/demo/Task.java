package com.jdonee.insight.domain.demo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.jdonee.insight.domain.IdEntity;
import com.jdonee.insight.util.mybatis.MyBatisTableName;

@MyBatisTableName(name = "tb_task", names = "tb_task t,tb_user u")
public class Task extends IdEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;

	private String description;

	private User user;

	// JSR303 BeanValidator的校验规则
	@NotNull
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
