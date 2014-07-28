package com.jdonee.insight.task.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.jdonee.insight.framework.domain.IdEntity;
import com.jdonee.insight.framework.util.mybatis.MyBatisTableName;

@Data
@NoArgsConstructor
@MyBatisTableName(name = "tb_task")
public class Task extends IdEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// JSR303 BeanValidator的校验规则
	@NotNull
	private String title;

	private String description;

	private Long userId;
}
