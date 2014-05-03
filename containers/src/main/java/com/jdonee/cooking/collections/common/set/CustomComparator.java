package com.jdonee.cooking.collections.common.set;

import java.util.Comparator;

/**
 * 自定义比较器
 * 字典顺序反向处理
 * 
 * @author ZengAihui
 *
 */
public class CustomComparator<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		if (((T) o1).equals(o2)) {
			return 0;
		}
		return ((Comparable<T>) o1).compareTo(o2) * -1;
	}
}
