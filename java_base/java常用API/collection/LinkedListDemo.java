package cn.copper.collection;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		
		LinkedList link = new LinkedList();
		
		link.addFirst("ssa1");
		link.addFirst("ssa2");
		link.addFirst("ssa3");
		
		System.out.println(link);
		
		while(!link.isEmpty())
		{
			System.out.println(link.removeFirst());
		}
		
	}
	
}
