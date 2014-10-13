package com.jdonee.framework.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdonee.framework.dao.BaseDao;
import com.jdonee.framework.util.commons.GenericsUtils;
import com.jdonee.framework.util.mybatis.MyBatisTableName;
import com.jdonee.framework.util.pagination.Page;
import com.jdonee.framework.util.pagination.Page.Sort;

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
		int result = 0;
		for (T t : list) {
			result += baseDao.update(t);
		}
		return result;
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
		List<T> pageList = baseDao.findPageList(tableName, page.getParamsMap(), page.getPageSort(), rowBounds);
		page.setResult(pageList);
		return page;
	}

	public int count(Map params) {
		return baseDao.count(tableName, params);
	}

	public List<T> findPageList(Map params, Sort sort, int offset, int limit) {
		RowBounds rowBounds = new RowBounds(offset, limit);// 使用RowBounds计算偏移量和偏移总数
		return baseDao.findPageList(tableName, params, sort, rowBounds);
	}

}
