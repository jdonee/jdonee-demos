package com.jdonee.insight.task.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.jdonee.framework.domain.IdEntity;
import com.jdonee.framework.util.mybatis.MyBatisTableName;

@Data
@EqualsAndHashCode(callSuper = false)
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
