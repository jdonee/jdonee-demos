package com.jdonee.cooking.collections.common.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * List容器的对象允许重复，Set容器的对象不允许重复
 * Hashset采用哈希算法(Hash),加入容器的对象必须重新定义hashCode()。
 * Hashset根据哈希码确定对象在容器中存储的位置，也可根据哈希码迅速查账容器的对象。
 * 
 * @author ZengAihui
 *
 */
public class HashSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("jdonee");
		set.add("Frank");
		set.add("lovefly_zero");
		set.add("jdonee");

		Iterator<String> iterator = set.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next() + " ");
		}
		System.out.println();

		set.remove("Frank");
		// for loop循环
		for (String element : set) {
			System.out.println(element + " ");
		}
		System.out.println();

	}
}
