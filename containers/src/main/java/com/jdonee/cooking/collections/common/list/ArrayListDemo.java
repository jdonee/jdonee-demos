package com.jdonee.cooking.collections.common.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ArrayList普通实现
 * 
 * @author ZengAihui
 * 
 */
public class ArrayListDemo {

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
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
			System.out.println();
		}

	}

}
