package com.jdonee.insight.rest.task;

import java.net.URI;
import java.util.List;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.jdonee.insight.MediaTypes;
import com.jdonee.insight.domain.demo.Task;
import com.jdonee.insight.dto.TaskDTO;
import com.jdonee.insight.rest.RestException;
import com.jdonee.insight.service.task.TaskService;
import com.jdonee.insight.util.commons.beanvalidator.BeanValidators;
import com.jdonee.insight.util.commons.mapper.BeanMapper;

/**
 * Task的Restful API的Controller.
 * 
 * @author Jdonee
 *
 */
@RestController
@RequestMapping(value = "/api/v1/task")
@Scope("prototype")
public class TaskRestController {

	private static Logger logger = LoggerFactory.getLogger(TaskRestController.class);

	@Autowired
	private TaskService taskService;

	@Autowired
	private Validator validator;

	@RequestMapping(method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public List<TaskDTO> list() {
		List<TaskDTO> dtos = taskService.findAllTask();
		return dtos;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public TaskDTO get(@PathVariable("id") Long id) {
		TaskDTO task = taskService.findTask(id);
		if (task == null) {
			String message = "任务不存在(id:" + id + ")";
			logger.warn(message);
			throw new RestException(HttpStatus.NOT_FOUND, message);
		}
		return task;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaTypes.JSON)
	public ResponseEntity<?> create(@RequestBody TaskDTO taskDTO, UriComponentsBuilder uriBuilder) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, taskDTO);

		// 保存任务
		Task task = BeanMapper.map(taskDTO, Task.class);
		task.setUserId(taskDTO.getUser().getId());
		taskService.save(task);

		// 按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		Long id = task.getId();
		URI uri = uriBuilder.path("/api/v1/task/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaTypes.JSON)
	// 按Restful风格约定，返回204状态码, 无内容. 也可以返回200状态码.
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody TaskDTO taskDTO, @PathVariable("id") Long id) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, taskDTO);
		// 更新任务
		Task task = BeanMapper.map(taskDTO, Task.class);
		task.setId(id);
		task.setUserId(taskDTO.getUser().getId());
		taskService.update(task);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		taskService.delete(id);
	}
}
