package com.jdonee.insight.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

/**
 * 数据库操作基础接口，封装了常用的操作函数
 * 
 * @author ZengAihui
 * 
 * @param <T>
 */
@Component
public interface BaseDao<T, PK extends Serializable> extends Serializable {

	final static String MAPPER_ID = "id";

	/**
	 * Mybatis常用的单表映射名称
	 */
	static final String MAPPER_TABLE_NAME = "tableName";

	/**
	 * Mybatis常用的多表映射名称
	 */
	static final String MAPPER_TABLE_NAMES = "tableNames";

	/**
	 * Mybatis常用的列表名称
	 */
	static final String MAPPER_LIST = "list";

	/**
	 * Mybatis常用的参数集合映射名称
	 */
	static final String MAPPER_PARAMS = "params";

	/**
	 * @Description: 保存对象
	 * @param t
	 * @return
	 * @throws
	 */
	int save(T t);

	/**
	 * @Description: 根据主键删除数据
	 * @param id
	 * @return
	 * @throws
	 */

	int delete(@Param(MAPPER_TABLE_NAME) String tableName, @Param(MAPPER_ID) PK id);

	/**
	 * @Description: 修改数据对象
	 * @param t
	 * @return
	 * @throws
	 */
	int update(T t);

	/**
	 * @Description: 根据主键获取实体对象
	 * @param id
	 * @return T
	 * @throws
	 */
	T findOneById(@Param(MAPPER_TABLE_NAME) String tableName, @Param(MAPPER_ID) PK id);

	/**
	 * @Description: 查询所有数据
	 * @return List<T>
	 * @throws
	 */
	List<T> findAll(@Param(MAPPER_TABLE_NAME) String tableName);

	/**
	 * @Description: 根据参数列表获取实体对象
	 * @param params
	 * @return T
	 * @throws
	 */
	T findOneByParams(@Param(MAPPER_TABLE_NAME) String tableName, @Param(MAPPER_PARAMS) Map<String, Object> params);

	/**
	 * @Description: 根据参数列表获取实体对象列表
	 * @param params
	 * @return List<T>
	 * @throws
	 */
	List<T> findListByParams(@Param(MAPPER_TABLE_NAME) String tableName,
			@Param(MAPPER_PARAMS) Map<String, Object> params);

	/**
	 * 分页集合
	 * 
	 * @param tableName
	 * @param params
	 * @param rowBounds
	 * @return
	 */
	List<T> findPageList(@Param(MAPPER_TABLE_NAME) String tableName, @Param(MAPPER_PARAMS) Map<String, Object> params,
			RowBounds rowBounds);

	/**
	 * 统计
	 * 
	 * @param tableNames
	 * @param params
	 * @return
	 */
	int count(@Param(MAPPER_TABLE_NAME) String tableName, @Param(MAPPER_PARAMS) Map<String, Object> params);

	/**
	 * 
	 * Description: 批量保存
	 * 
	 * @param tableName
	 * @param list
	 * @return
	 * @throws
	 */
	int saveBatch(@Param(MAPPER_TABLE_NAME) String tableName, @Param(MAPPER_LIST) List<T> list);

	/**
	 * 
	 * Description: 批量更新
	 * 
	 * @param tableName
	 * @param list
	 * @return
	 * @throws
	 */
	int updateBatch(@Param(MAPPER_TABLE_NAME) String tableName, @Param(MAPPER_LIST) List<T> list);

	/**
	 * 
	 * Description: 批量删除
	 * 
	 * @param tableName
	 * @param list
	 * @return
	 * @throws
	 */
	int deleteBatch(@Param(MAPPER_TABLE_NAME) String tableName, @Param(MAPPER_LIST) List<PK> list);
}
