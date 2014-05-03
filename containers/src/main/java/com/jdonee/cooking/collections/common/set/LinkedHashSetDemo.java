package com.jdonee.cooking.collections.common.set;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 利用LinkedHashSet实现排序
 * 
 * @author ZengAihui
 *
 */
public class LinkedHashSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<String>();
		set.add("jdonee");
		set.add("Frank");
		set.add("lovefly_zero");
		set.add("jdonee");

		// for loop循环
		for (String element : set) {
			System.out.println(element + " ");
		}
		System.out.println();

	}
}
