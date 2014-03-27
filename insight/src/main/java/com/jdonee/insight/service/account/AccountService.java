/**
 * 
 */
package com.jdonee.insight.service.account;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableMap;
import com.jdonee.insight.domain.demo.User;
import com.jdonee.insight.service.BaseService;
import com.jdonee.insight.service.ServiceException;
import com.jdonee.insight.service.account.ShiroDbRealm.ShiroUser;
import com.jdonee.insight.service.task.TaskService;
import com.jdonee.insight.util.commons.Clock;
import com.jdonee.insight.util.commons.Encodes;
import com.jdonee.insight.util.commons.security.utils.Digests;

/**
 * 
 * 用户管理类.
 * 
 * @author ZengAihui
 * 
 */
@Component
@Transactional
public class AccountService extends BaseService<User, Long> {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	private static Logger logger = LoggerFactory.getLogger(AccountService.class);

	private Clock clock = Clock.DEFAULT;

	private TaskService taskService;

	/**
	 * 用户注册
	 * 
	 * @param user
	 */
	public void registerUser(User user) {
		entryptPassword(user);
		user.setRoles("user");
		user.setRegisterDate(clock.getCurrentDate());
		this.save(user);
	}

	/**
	 * 根据登录名查找用户
	 * 
	 * @param loginName
	 * @return
	 */
	@Transactional(readOnly = true)
	public User findUserByLoginName(String loginName) {
		return this.findOneByParams(ImmutableMap.of("loginName", loginName));
	}

	/**
	 * 更新用户
	 * 
	 * @param user
	 */
	public void updateUser(User user) {
		if (StringUtils.isNotBlank(user.getPlainPassword())) {
			entryptPassword(user);
		}
		this.update(user);
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	public void deleteUser(Long id) {
		if (isSupervisor(id)) {
			logger.warn("操作员{}尝试删除超级管理员用户", getCurrentUserName());
			throw new ServiceException("不能删除超级管理员用户");
		}
		this.delete(id);
		taskService.deleteByUserId(id);
	}

	/**
	 * 判断是否超级管理员.
	 */
	private boolean isSupervisor(Long id) {
		return id == 1;
	}

	/**
	 * 取出Shiro中的当前用户LoginName.
	 */
	private String getCurrentUserName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.loginName;
	}

	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));
		logger.debug("salt:" + user.getSalt());
		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
		logger.debug("password:" + user.getPlainPassword() + ",hashPassword:" + user.getPassword());
	}

	public void setClock(Clock clock) {
		this.clock = clock;
	}

	@Autowired
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

}
