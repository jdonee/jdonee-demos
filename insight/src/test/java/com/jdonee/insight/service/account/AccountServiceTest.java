package com.jdonee.insight.service.account;

import static org.assertj.core.api.Assertions.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jdonee.insight.account.dao.UserDao;
import com.jdonee.insight.account.domain.User;
import com.jdonee.insight.account.service.AccountService;
import com.jdonee.insight.account.service.ShiroDbRealm.ShiroUser;
import com.jdonee.insight.data.UserData;
import com.jdonee.insight.framework.service.BusinessLogger;
import com.jdonee.insight.framework.service.ServiceException;
import com.jdonee.insight.framework.util.commons.Clock.MockClock;
import com.jdonee.insight.framework.util.mybatis.MyBatisTableName;
import com.jdonee.insight.shiro.ShiroTestUtils;
import com.jdonee.insight.task.service.TaskService;

public class AccountServiceTest {

	@InjectMocks
	private AccountService accountService;

	@Mock
	private UserDao mockUserDao;

	@Mock
	private BusinessLogger mockBusinessLogger;

	@Mock
	private TaskService mockTaskService;

	private String tableName;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		MyBatisTableName table = User.class.getAnnotation(MyBatisTableName.class);
		if (null == table) {
			throw new RuntimeException("类-" + User.class + ",未用@MyBatisTableName注解标识!!");
		}
		tableName = table.name();
		ShiroTestUtils.mockSubject(new ShiroUser(3L, "foo", "Foo"));
	}

	@Test
	public void registerUser() {
		User user = UserData.randomNewUser();
		Date currentTime = new Date();
		accountService.setClock(new MockClock(currentTime));

		accountService.registerUser(user);

		// 验证user的角色，注册日期和加密后的密码都被自动更新了。
		assertThat(user.getRoles()).isEqualTo("user");
		assertThat(user.getRegisterDate()).isEqualTo(currentTime);
		assertThat(user.getPassword()).isNotNull();
		assertThat(user.getSalt()).isNotNull();
	}

	@Test
	public void updateUser() {
		// 如果明文密码不为空，加密密码会被更新.
		User user = UserData.randomNewUser();
		accountService.updateUser(user);
		assertThat(user.getSalt()).isNotNull();

		// 如果明文密码为空，加密密码无变化。
		User user2 = UserData.randomNewUser();
		user2.setPlainPassword(null);
		accountService.updateUser(user2);
		assertThat(user2.getSalt()).isNull();
	}

	@Test
	public void deleteUser() {
		// 正常删除用户.
		accountService.deleteUser(2L);
		Mockito.verify(mockUserDao).delete(tableName, 2L);
		Mockito.verify(mockTaskService).deleteByUserId(2L);

		// 删除超级管理用户抛出异常, userDao没有被执行
		try {
			accountService.deleteUser(1L);
			failBecauseExceptionWasNotThrown(ServiceException.class);
		} catch (ServiceException e) {
			// expected exception
		}
		Mockito.verify(mockUserDao, Mockito.never()).delete(tableName, 1L);
		Mockito.verify(mockTaskService, Mockito.never()).deleteByUserId(1L);
	}

}
