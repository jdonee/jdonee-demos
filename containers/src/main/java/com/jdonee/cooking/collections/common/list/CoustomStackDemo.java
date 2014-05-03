package com.jdonee.cooking.collections.common.list;

import java.util.Scanner;

/**
 * Stack的简单实现
 * 
 * @author ZengAihui
 * 
 */
public class CoustomStackDemo {

	private static Scanner scanner;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		CustomStack<String> stack = new CustomStack<String>();

		System.out.println("输入名称(使用quit结束)");

		while (true) {

			System.out.print("# ");
			String input = scanner.next();
			if (input.equals("quit")) {
				break;
			}
			stack.push(input);
		}

		System.out.print("显示输入：");

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

		System.out.println();

	}

}
