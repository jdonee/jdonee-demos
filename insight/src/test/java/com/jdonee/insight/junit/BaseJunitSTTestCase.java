/**
 * 
 */
package com.jdonee.insight.junit;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.jdonee.insight.spring.Profiles;
import com.jdonee.insight.spring.SpringContextTestCase;

/**
 * 单元测试基类
 * 
 * @author ZengAihui
 * 
 */
@DirtiesContext
@ActiveProfiles(Profiles.DEVELOPMENT)
@ContextConfiguration(locations = { "/applicationContext.xml", "/spring-mybatis.xml" })
public abstract class BaseJunitSTTestCase extends SpringContextTestCase {

}
