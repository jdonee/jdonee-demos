/**
 * 
 */
package com.jdonee.insight.service.task;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.google.common.collect.Maps;
import com.jdonee.insight.dao.demo.TaskDao;
import com.jdonee.insight.domain.demo.Task;
import com.jdonee.insight.util.pagination.Page;

/**
 * @author ZengAihui
 * 
 */
public class TaskServiceTest {

	@InjectMocks
	private TaskService taskService;

	@Mock
	private TaskDao mockTaskDao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Ignore
	@Test
	public void findTaskPage() {
		Page<Task> taskPage = new Page();
		Map<String, Object> paramsMap = Maps.newHashMap();
		taskPage.setParamsMap(paramsMap);
		taskPage = taskService.findTaskPage(taskPage);
		assertThat(taskPage.getResult()).hasSize(5);

		assertThat(taskPage.getResult().get(0).getUser()).isNotNull();
		assertThat(taskPage.getResult().get(0).getUser().getName()).isNotNull();
		assertThat(taskPage.getResult().get(0).getUser().getLoginName()).isEmpty();
	}

}
