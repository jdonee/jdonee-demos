package com.jdonee.insight.service.task;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.google.common.collect.Maps;
import com.jdonee.insight.account.domain.User;
import com.jdonee.insight.account.service.AccountService;
import com.jdonee.insight.framework.util.mybatis.MyBatisTableName;
import com.jdonee.insight.framework.util.mybatis.PaginationInterceptor;
import com.jdonee.insight.framework.util.pagination.Page;
import com.jdonee.insight.task.dao.TaskDao;
import com.jdonee.insight.task.domain.Task;
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

	private String tableName;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		MyBatisTableName table = Task.class.getAnnotation(MyBatisTableName.class);
		if (null == table) {
			throw new RuntimeException("类-" + User.class + ",未用@MyBatisTableName注解标识!!");
		}
		tableName = table.name();
	}

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
