/**
 * 
 */
package com.jdonee.framework.util.mybatis;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识MyBatis的非数据库字段，方便分析字段
 * 
 * @author Jdonee
 * 
 */
@Target({ METHOD, FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MyBatisTransient {
	String value() default "";
}
