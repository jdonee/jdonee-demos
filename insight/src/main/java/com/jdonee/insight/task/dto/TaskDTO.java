package com.jdonee.insight.task.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.jdonee.framework.service.BaseDTO;
import com.jdonee.insight.account.dto.UserDTO;

/**
 * 任务通用类
 * 
 * @author ZengAihui
 * 
 */
@Getter
@Setter
public class TaskDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotNull
	private String title;
	private String description;
	@NotNull
	private UserDTO user;

	/**
	 * 重新实现toString()函数方便在日志中打印DTO信息.
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
