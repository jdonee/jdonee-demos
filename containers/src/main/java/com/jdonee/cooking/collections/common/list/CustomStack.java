package com.jdonee.cooking.collections.common.list;

import java.util.LinkedList;

/**
 * 由于LinkedList使用链表，在进行插入语删除动作时有较好的效果，适合用来实现堆栈(stack)和队列(queue)。
 * 
 * 实现一个简单的栈(先进后出)
 * 
 * @author ZengAihui
 *
 */
public class CustomStack<T> {

	private LinkedList<T> linkedList;

	public CustomStack() {
		linkedList = new LinkedList<T>();
	}

	// 将元素加入链表前端
	public void push(T element) {
		linkedList.addFirst(element);
	}

	// 取得链表的第一个元素
	public void top() {
		linkedList.getFirst();
	}

	// 移除链表的第一个元素并返回它
	public T pop() {
		return linkedList.removeFirst();
	}

	// 链表是否为空
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}

}
