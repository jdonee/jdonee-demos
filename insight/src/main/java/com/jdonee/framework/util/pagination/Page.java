package com.jdonee.framework.util.pagination;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author zengaihui
 *         简单分页插件
 */
public class Page<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private int pageSize = 10; // 每页显示记录数

	private int currentPage = 1; // 当前页码

	private int dataCount = Integer.MAX_VALUE;// 数据总条数

	/**
	 * 条件组
	 */
	private Map<String, Object> paramsMap = Maps.newHashMap();

	/**
	 * 排序
	 */
	private Sort pageSort;

	/**
	 * 排序参数
	 */
	private String sortParam;

	/**
	 * 是否有下一页
	 */
	boolean next = false;
	/**
	 * 是否有前一页
	 */
	boolean prev = false;

	private List<T> result = Lists.newArrayList();

	public Page() {
	}

	public Page(int pageSize) {
		this.pageSize = pageSize;
	}

	public Page(int pageSize, int currentPage) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}

	// 获取offset
	public int getOffset() {
		return (currentPage - 1) * pageSize;
	}

	// 获取limit
	public int getLimit() {
		return getPageSize();
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		int temPage = currentPage;
		if (temPage < 1) {
			temPage = 1;
		}
		if (temPage > getMaxPage()) {
			temPage = getMaxPage();
		}
		this.currentPage = temPage;
	}

	// 获取最大的页码
	public int getMaxPage() {
		int maxPage = (int) Math.ceil((double) dataCount / pageSize);// ceil 无条件进位，主要满足 1/4 5/4 默认整数相除被截断的问题
		if (maxPage < 1) {
			maxPage = 1;
		}
		return maxPage;
	}

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	public boolean isNext() {
		return currentPage < getMaxPage();
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrev() {
		return (currentPage - 1) > 0;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public Map<String, Object> getParamsMap() {
		return paramsMap;
	}

	public void setParamsMap(Map<String, Object> paramsMap) {
		this.paramsMap = paramsMap;
	}

	public String getSortParam() {
		return sortParam;
	}

	public void setSortParam(String sortParam) {
		this.sortParam = sortParam;
	}

	public Sort getPageSort() {
		return pageSort;
	}

	public void setPageSort(Sort pageSort) {
		this.pageSort = pageSort;
	}

	/**
	 * @author ZengAihui
	 * 
	 */
	public static class Sort implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		// 排序项
		private String sortItem;
		// 对应的数据库字段
		private String sortColumn;
		// 降序
		private boolean desc;

		public Sort(String sortItem, boolean desc) {
			super();
			this.sortItem = sortItem;
			this.desc = desc;
		}

		public Sort(String sortItem, String sortColumn, boolean desc) {
			super();
			this.sortItem = sortItem;
			this.sortColumn = sortColumn;
			this.desc = desc;
		}

		public String getSortColumn() {
			return sortColumn;
		}

		public void setSortColumn(String sortColumn) {
			this.sortColumn = sortColumn;
		}

		public String getSortItem() {
			return sortItem;
		}

		public void setSortItem(String sortItem) {
			this.sortItem = sortItem;
		}

		public boolean isDesc() {
			return desc;
		}

		public void setDesc(boolean desc) {
			this.desc = desc;
		}

		@Override
		public String toString() {
			return sortColumn;
		}

		/**
		 * 重载hashCode,只计算sortColumn;
		 */
		@Override
		public int hashCode() {
			return Objects.hashCode(sortColumn);
		}

		/**
		 * 重载equals,只计算sortColumn;
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Sort other = (Sort) obj;
			if (sortColumn == null) {
				if (other.sortColumn != null) {
					return false;
				}
			} else if (!sortColumn.equals(other.sortColumn)) {
				return false;
			}
			return true;
		}

	}

}
