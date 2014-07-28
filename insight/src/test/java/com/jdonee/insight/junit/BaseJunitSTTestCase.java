/**
 * 
 */
package com.jdonee.insight.junit;

import org.junit.Before;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.jdonee.framework.util.commons.GenericsUtils;
import com.jdonee.framework.util.mybatis.MyBatisTableName;
import com.jdonee.insight.spring.Profiles;
import com.jdonee.insight.spring.SpringTransactionalTestCase;

/**
 * 事务单元测试基类
 * 
 * @author ZengAihui
 * 
 */
@DirtiesContext
@ActiveProfiles(Profiles.UNIT_TEST)
@ContextConfiguration(locations = { "/applicationContext.xml", "/spring-mybatis.xml" })
public abstract class BaseJunitSTTestCase<T> extends SpringTransactionalTestCase {

	protected String tableName;

	private Class<T> entityClass;

	@Before
	public void setUp() {
		entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());
		MyBatisTableName table = entityClass.getAnnotation(MyBatisTableName.class);
		if (null == table) {
			throw new RuntimeException("类-" + this.entityClass + ",未用@MyBatisTableName注解标识!!");
		}
		tableName = table.name();
	}
}
