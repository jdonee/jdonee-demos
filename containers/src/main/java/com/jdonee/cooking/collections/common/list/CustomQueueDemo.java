package com.jdonee.cooking.collections.common.list;

import java.util.Scanner;

/**
 * Queue的简单实现
 * 
 * @author ZengAihui
 * 
 */
public class CustomQueueDemo {

	private static Scanner scanner;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		CustomQueue<String> queue = new CustomQueue<String>();

		System.out.println("输入名称(使用quit结束)");

		while (true) {

			System.out.print("# ");
			String input = scanner.next();
			if (input.equals("quit")) {
				break;
			}
			queue.offer(input);
		}

		System.out.print("显示输入：");

		while (!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");
		}

		System.out.println();
	}

}
