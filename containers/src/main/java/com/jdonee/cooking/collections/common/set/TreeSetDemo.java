package com.jdonee.cooking.collections.common.set;

import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet使用红黑树结构对加入的对象排序
 * 
 * 字符串按照字典顺序排序的
 * 
 * @author ZengAihui
 *
 */
public class TreeSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> set = new TreeSet<String>();
		set.add("jdonee");
		set.add("Frank");
		set.add("lovefly_zero");

		// for loop循环
		for (String element : set) {
			System.out.println(element + " ");
		}
		System.out.println();

	}
}
