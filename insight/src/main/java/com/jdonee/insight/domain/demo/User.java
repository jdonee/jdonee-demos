package com.jdonee.insight.domain.demo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.ImmutableList;
import com.jdonee.insight.domain.IdEntity;
import com.jdonee.insight.util.mybatis.MyBatisTableName;
import com.jdonee.insight.util.mybatis.MyBatisTransient;

@MyBatisTableName(name = "tb_user")
public class User extends IdEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank
	private String loginName;

	@NotBlank
	private String name;

	// 不持久化到数据库，也不显示在Restful接口的属性.
	@MyBatisTransient
	@JsonIgnore
	private String plainPassword;

	private String password;

	private String salt;

	@MyBatisTransient
	@JsonIgnore
	private String roles;

	// 设定JSON序列化时的日期格式
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date registerDate;

	public User() {
		super();
		MyBatisTableName table = this.getClass().getAnnotation(MyBatisTableName.class);
		this.tableName = table.name();
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

	public List<String> getRoleList() {
		// 角色列表在数据库中实际以逗号分隔字符串存储，因此返回不能修改的List.
		return ImmutableList.copyOf(StringUtils.split(roles, ","));
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