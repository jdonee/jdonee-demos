package com.jdonee.cooking.collections.common.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * ArrayList和Iterator结合
 * 
 * @author ZengAihui
 *
 */
public class IteratorDemo {

	private static Scanner scanner;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		List<String> list = new ArrayList<String>();

		System.out.println("输入名称(使用quit结束)");

		while (true) {
			System.out.print("# ");
			String input = scanner.next();
			if (input.equals("quit")) {
				break;
			}
			list.add(input);
		}

		System.out.print("显示输入：");
		// 使用Iterator取得元素
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

	}

}
