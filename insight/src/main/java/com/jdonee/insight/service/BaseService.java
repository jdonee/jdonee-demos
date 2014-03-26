package com.jdonee.insight.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jdonee.insight.dao.BaseDao;
import com.jdonee.insight.util.commons.GenericsUtils;
import com.jdonee.insight.util.mybatis.MyBatisTableName;

/**
 * @author ZengAihui
 * 
 */
@Component
public abstract class BaseService<T, PK extends Serializable> {

	@Autowired
	protected BaseDao<T, PK> baseDao;

	private Class<T> entityClass;

	private String tableName;

	public BaseService() {
		super();
		this.entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());
		MyBatisTableName table = this.entityClass.getAnnotation(MyBatisTableName.class);
		if (null == table) {
			throw new RuntimeException("类-" + this.entityClass + ",未用@MyBatisTableName注解标识!!");
		}
		tableName = table.name();
	}

	public int save(T t) {
		return baseDao.save(t);
	}

	public int delete(PK id) {
		return baseDao.delete(tableName, id);
	}

	public int update(T t) {
		return baseDao.update(t);
	}

	public List<T> findAll() {
		return baseDao.findAll(tableName);
	}

	public T findOneById(PK id) {
		return baseDao.findOneById(tableName, id);
	}

	protected T findOneByParams(Map params) {
		return baseDao.findOneByParams(tableName, params);
	}

	protected List<T> findListByParams(Map params) {
		return baseDao.findListByParams(tableName, params);
	}

	public int saveBatch(List<T> list) {
		return baseDao.saveBatch(tableName, list);
	}

	public int deleteBatch(List<PK> list) {
		return baseDao.deleteBatch(tableName, list);
	}

	public int updateBatch(List<T> list) {
		return baseDao.updateBatch(tableName, list);
	}
}
