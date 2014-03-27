package com.jdonee.insight.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jdonee.insight.dao.BaseDao;
import com.jdonee.insight.util.commons.GenericsUtils;
import com.jdonee.insight.util.mybatis.MyBatisTableName;
import com.jdonee.insight.util.pagination.Page;

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

	protected int save(T t) {
		return baseDao.save(t);
	}

	protected int delete(PK id) {
		return baseDao.delete(tableName, id);
	}

	protected int update(T t) {
		return baseDao.update(t);
	}

	protected List<T> findAll() {
		return baseDao.findAll(tableName);
	}

	protected T findOneById(PK id) {
		return baseDao.findOneById(tableName, id);
	}

	protected int saveBatch(List<T> list) {
		return baseDao.saveBatch(tableName, list);
	}

	protected int deleteBatch(List<PK> list) {
		return baseDao.deleteBatch(tableName, list);
	}

	protected int updateBatch(List<T> list) {
		return baseDao.updateBatch(tableName, list);
	}

	protected T findOneByParams(Map params) {
		return baseDao.findOneByParams(tableName, params);
	}

	protected List<T> findListByParams(Map params) {
		return baseDao.findListByParams(tableName, params);
	}

	protected Page<T> findPage(Page<T> page) {
		page.setDataCount(count(page.getParamsMap()));
		RowBounds rowBounds = new RowBounds(page.getOffset(), page.getLimit());// 使用RowBounds计算偏移量和偏移总数
		List<T> pageList = baseDao.findPageList(tableName, page.getParamsMap(), rowBounds);
		page.setResult(pageList);
		return page;
	}

	protected int count(Map params) {
		return baseDao.count(tableName, params);
	}
}
