package com.jdonee.insight.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdonee.insight.dao.BaseDao;
import com.jdonee.insight.util.commons.GenericsUtils;
import com.jdonee.insight.util.mybatis.MyBatisTableName;
import com.jdonee.insight.util.pagination.Page;

/**
 * @author ZengAihui
 * 
 */
public abstract class BaseService<T, PK extends Serializable> {

	@Autowired
	protected BaseDao<T, PK> baseDao;

	private Class<T> entityClass;

	protected String tableName;

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

	public int saveBatch(List<T> list) {
		return baseDao.saveBatch(tableName, list);
	}

	public int deleteBatch(List<PK> list) {
		return baseDao.deleteBatch(tableName, list);
	}

	public int updateBatch(List<T> list) {
		return baseDao.updateBatch(tableName, list);
	}

	public T findOneByParams(Map params) {
		return baseDao.findOneByParams(tableName, params);
	}

	public List<T> findListByParams(Map params) {
		return baseDao.findListByParams(tableName, params);
	}

	public Page<T> findPage(Page<T> page) {
		page.setDataCount(count(page.getParamsMap()));
		RowBounds rowBounds = new RowBounds(page.getOffset(), page.getLimit());// 使用RowBounds计算偏移量和偏移总数
		List<T> pageList = baseDao.findPageList(tableName, page.getParamsMap(), rowBounds);
		page.setResult(pageList);
		return page;
	}

	public int count(Map params) {
		return baseDao.count(tableName, params);
	}

}
