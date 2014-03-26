/**
 * 
 */
package com.jdonee.insight.junit;

import org.junit.Before;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.jdonee.insight.spring.Profiles;
import com.jdonee.insight.spring.SpringContextTestCase;
import com.jdonee.insight.util.commons.GenericsUtils;
import com.jdonee.insight.util.commons.Reflections;
import com.jdonee.insight.util.mybatis.MyBatisTableName;

/**
 * 单元测试基类
 * 
 * @author ZengAihui
 * 
 */
@DirtiesContext
@ActiveProfiles(Profiles.DEVELOPMENT)
@ContextConfiguration(locations = { "/applicationContext.xml", "/spring-mybatis.xml" })
public abstract class BaseJunitSTTestCase<T> extends SpringContextTestCase {

	protected String tableName;

	private Class<T> entityClass;

	@Before
	public void setUp() {
		this.entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());
		MyBatisTableName table = entityClass.getAnnotation(MyBatisTableName.class);
		if (null == table) {
			throw new RuntimeException("类-" + this.entityClass + ",未用@MyBatisTableName注解标识!!");
		}
		tableName = table.name();
		Reflections.invokeSetter(this.entityClass, "tableName", table.name());
	}
}
