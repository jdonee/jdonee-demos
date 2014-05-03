package com.jdonee.cooking.collections.common.set;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * SubSet获取
 * 
 * @author ZengAihui
 *
 */
public class HashSetSubSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Integer> set = new LinkedHashSet<Integer>();
		for (int i = 0; i <= 3; i++) {
			set.add(i);
		}

		List<Integer> list = new ArrayList<Integer>(set);
		Set<Integer> subSet = new LinkedHashSet<Integer>(list.subList(1, 3));

		System.out.println(subSet.toString());

	}
}
