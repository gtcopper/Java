package cn.copper.collection;

import java.util.LinkedList;

public class LinkedListTest {

	/**
	 * 用LinkedList模拟队列或堆栈数据结构
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		 * 模拟队列
		 */
		Queue q = new Queue();
		q.add("aaa");
		q.add("bbb");
		q.add("ccc");
		
		//System.out.println(q);
		
		while(!q.isEmpty())
		{
			System.out.print(q.get()+" ");
		}
		
		System.out.println();
		/*
		 * 模拟堆栈
		 */
		Stack s = new Stack();
		s.add("aaa");
		s.add("bbb");
		s.add("ccc");
		
		while(!s.isEmpty())
		{
			System.out.print(s.get()+" ");
		}
		
	}
}
/**
 * 队列数据结构
 * 
 * */
class Queue {
	private LinkedList link;
	
	Queue()
	{
		link = new LinkedList();
	}
	/**
	 * 队列添加元素
	 * @param o
	 */
	public void add(Object o)
	{
		link.addFirst(o);
	}
	
	public Object get()
	{
		return link.removeLast();
	}
	
	public boolean isEmpty()
	{
		return link.isEmpty();
	}
}
/**
 * 模拟堆栈
 * @author Administrator
 *
 */
class Stack {
	private LinkedList link;
	
	Stack()
	{
		link = new LinkedList();
	}
	
	public void add(Object o)
	{
		link.addFirst(o);
	}
	public Object get()
	{
		return link.removeFirst();
	}
	
	public boolean isEmpty()
	{
		return link.isEmpty();
	}
}
