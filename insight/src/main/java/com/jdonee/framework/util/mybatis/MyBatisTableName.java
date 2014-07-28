/**
 * 
 */
package com.jdonee.framework.util.mybatis;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识MyBatis的表名称
 * 
 * @author Jdonee
 * 
 */
@Target({ TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface MyBatisTableName {

	/**
	 * 单表名称
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * 多表名称(可选)
	 * 
	 * @return
	 */
	String names() default "";
}
