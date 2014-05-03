package com.jdonee.cooking.collections.common.list;

import java.util.LinkedList;

/**
 * 由于LinkedList使用链表，在进行插入语删除动作时有较好的效果，适合用来实现堆栈(stack)和队列(queue)。
 * 
 * 实现一个简单的先进先出的队列
 * 
 * @author ZengAihui
 *
 */
public class CustomQueue<T> {

	private LinkedList<T> linkedList;

	public CustomQueue() {
		linkedList = new LinkedList<T>();
	}

	// 将元素加入链表前端
	public void offer(T element) {
		linkedList.addFirst(element);
	}

	// 移除链表的最后的元素并返回它
	public T poll() {
		return linkedList.removeLast();
	}

	// 链表是否为空
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}

}
