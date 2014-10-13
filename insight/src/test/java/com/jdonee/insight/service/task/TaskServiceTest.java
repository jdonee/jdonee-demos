package com.jdonee.insight.service.task;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.google.common.collect.Maps;
import com.jdonee.framework.util.pagehelper.PageInfo;
import com.jdonee.insight.account.service.AccountService;
import com.jdonee.insight.task.dao.TaskDao;
import com.jdonee.insight.task.dto.TaskDTO;
import com.jdonee.insight.task.service.TaskService;

/**
 * @author ZengAihui
 * 
 */
public class TaskServiceTest {

	@InjectMocks
	private TaskService taskService;

	@Mock
	private TaskDao mockTaskDao;

	@Mock
	private AccountService mockAccountService;

	@Test
	public void findTaskPage() {
		Map<String, Object> paramsMap = Maps.newHashMap();
		PageInfo<TaskDTO> taskPage = taskService.findTaskPage(paramsMap, 1, 10);
		assertThat(taskPage.getList()).hasSize(5);

		assertThat(taskPage.getList().get(0).getUser()).isNotNull();
		assertThat(taskPage.getList().get(0).getUser().getName()).isNotNull();
		assertThat(taskPage.getList().get(0).getUser().getLoginName()).isEmpty();
	}

}
