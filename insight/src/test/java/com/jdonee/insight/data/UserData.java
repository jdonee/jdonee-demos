package com.jdonee.insight.data;

import com.jdonee.insight.account.domain.User;

/**
 * User相关实体测试数据生成.
 * 
 * @author Jdonee
 *
 */
public class UserData {

	public static User randomNewUser() {
		User user = new User();
		user.setLoginName(RandomData.randomName("user"));
		user.setName(RandomData.randomName("User"));
		user.setPlainPassword(RandomData.randomName("password"));
		return user;
	}
}
