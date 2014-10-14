package com.jdonee.framework.util.pagehelper;

import java.util.Map;
import java.util.Set;

import javax.servlet.ServletRequest;

import org.springframework.stereotype.Component;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.jdonee.framework.util.commons.Collections3;
import com.jdonee.framework.web.Servlets;

@Component
public class QuerySearch {

	/**
	 * 查询条件
	 */
	private Map<String, Object> searchParams;

	/**
	 * 页码
	 */
	private int pageNumber;

	/**
	 * 页数量
	 */
	private int pageSize;

	/**
	 * 排序
	 */
	private Set<String> sortParams;

	public QuerySearch() {
		super();
	}

	public QuerySearch(Map<String, Object> searchParams, int pageNumber, int pageSize, Set<String> sortParams) {
		this.searchParams = searchParams;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.sortParams = sortParams;
	}

	public QuerySearch(Map<String, Object> searchParams, int pageNumber, int pageSize) {
		this.searchParams = searchParams;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	public Map<String, Object> getSearchParams() {
		return searchParams;
	}

	public void setSearchParams(Map<String, Object> searchParams) {
		this.searchParams = searchParams;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Set<String> getSortParams() {
		return sortParams;
	}

	public void setSortParams(Set<String> sortParams) {
		this.sortParams = sortParams;
	}

	/**
	 * 整合自定义集合
	 * 
	 * @param localParams
	 * @param request
	 * @param prefix
	 */
	public void initSearchParams(Map localParams, ServletRequest request, String prefix) {
		searchParams = Maps.newHashMap();
		searchParams.putAll(Servlets.getParametersStartingWith(request, prefix));
		searchParams.putAll(localParams);
	}

	/**
	 * 输出自定义集合
	 * 
	 * @param removeKey
	 * @param prefix
	 * @return
	 */
	public String outputSearchParams(Set<String> removeKey, String prefix) {
		for (String key : removeKey) {
			searchParams.remove(key);
		}
		return Servlets.encodeParameterStringWithPrefix(searchParams, prefix);
	}

	/**
	 * 生成排序
	 * 
	 * @param sortSet
	 * @return
	 */
	public Set<String> generateSorts(Set<String> sortSet) {
		Set sorts = Sets.newLinkedHashSet();
		if (Collections3.isNotEmpty(sortParams)) {
			for (String sort : sortParams) {
				if (sort.equals("auto")) {
					sorts.add("id");
				} else {
					if (sort.startsWith("-")) {// 负数表示降序
						sorts.add(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, sort.substring(1)) + " DESC");
					} else {
						sorts.add(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, sort));
					}
				}
			}
		}
		return sorts;
	}
}
