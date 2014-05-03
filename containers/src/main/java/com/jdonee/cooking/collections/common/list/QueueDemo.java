package com.jdonee.cooking.collections.common.list;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 在java5中新增加了java.util.Queue接口，用以支持队列的常见操作。该接口扩展了java.util.Collection接口。
 * Queue使用时要尽量避免Collection的add()和remove()方法，而是要使用offer()来加入元素，使用poll()来获取并移出元素。它们的优点是通过返回值可以判断成功与否，add()和remove(
 * )方法在失败的时候会抛出异常。 如果要使用前端而不移出该元素，使用element()或者peek()方法。
 * 值得注意的是LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
 * 
 * @author ZengAihui
 * 
 */
public class QueueDemo {

	private static Scanner scanner;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		Queue<String> queue = new LinkedList<String>();

		System.out.println("输入名称(使用quit结束)");

		while (true) {
			System.out.print("# ");
			String input = scanner.next();
			if (input.equals("quit")) {
				break;
			}
			queue.offer(input);// 加入元素至队列中
		}

		System.out.print("显示输入：");

		String element = null;
		while ((element = queue.poll()) != null) {
			System.out.print(element + " ");
		}

		System.out.println();
		// 所有元素移除时会抛出java.util.NoSuchElementException异常
		// System.out.println(queue.element());
		System.out.println("返回空：" + (queue.peek() == null));
	}

}
