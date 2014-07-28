package com.jdonee.insight.account.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.jdonee.framework.domain.IdEntity;
import com.jdonee.framework.util.Constants;
import com.jdonee.framework.util.mybatis.MyBatisTableName;
import com.jdonee.framework.util.mybatis.MyBatisTransient;

@Data
@NoArgsConstructor
@MyBatisTableName(name = "tb_user")
public class User extends IdEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotNull
	private String loginName;
	@NotNull
	private String name;
	// 不持久化到数据库，也不显示在Restful接口的属性.
	@MyBatisTransient
	@JsonIgnore
	private String plainPassword;
	private String password;
	private String salt;
	private String roles;
	// 设定JSON序列化时的日期格式
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date registerDate;

	public User(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public List<String> getRoleList() {
		List<String> roleList = Lists.newArrayList();
		if (StringUtils.isNotBlank(roles)) {// 角色列表在数据库中实际以逗号分隔字符串存储，因此返回不能修改的List.
			roleList = ImmutableList.copyOf(Splitter.on(Constants.DEFAULT_SEPARATOR).split(roles));
		}
		return roleList;
	}
}