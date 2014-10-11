package com.jdonee.insight.service.task;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.google.common.collect.Maps;
import com.jdonee.framework.util.mybatis.PaginationInterceptor;
import com.jdonee.framework.util.pagination.Page;
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
	private PaginationInterceptor mockPaginationInterceptor;

	@Mock
	private TaskDao mockTaskDao;

	@Mock
	private AccountService mockAccountService;

	@Test
	public void findTaskPage() {
		Page<TaskDTO> taskPage = new Page<TaskDTO>();
		Map<String, Object> paramsMap = Maps.newHashMap();
		taskPage.setParamsMap(paramsMap);
		taskPage = taskService.findTaskPage(taskPage);
		assertThat(taskPage.getResult()).hasSize(5);

		assertThat(taskPage.getResult().get(0).getUser()).isNotNull();
		assertThat(taskPage.getResult().get(0).getUser().getName()).isNotNull();
		assertThat(taskPage.getResult().get(0).getUser().getLoginName()).isEmpty();
	}

}
