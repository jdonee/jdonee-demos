package com.jdonee.insight.domain.demo;

import java.io.*;
import java.util.*;

import javax.validation.constraints.*;

import org.apache.commons.lang3.*;
import org.apache.commons.lang3.builder.*;

import com.fasterxml.jackson.annotation.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import com.jdonee.insight.domain.*;
import com.jdonee.insight.util.*;
import com.jdonee.insight.util.mybatis.*;

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

	public User() {
		super();
	}

	public User(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlainPassword() {
		return plainPassword;
	}

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@JsonIgnore
	public List<String> getRoleList() {
		List<String> roleList = Lists.newArrayList();
		// 角色列表在数据库中实际以逗号分隔字符串存储，因此返回不能修改的List.
		if (StringUtils.isNotBlank(roles)) {
			roleList = ImmutableList.copyOf(Splitter.on(Constants.DEFAULT_SEPARATOR).split(roles));
		}
		return roleList;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}