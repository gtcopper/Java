package cn.copper.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {

	public static void main(String[] args) {
		
		Collection coll = new ArrayList();
		
		coll.add("ass");
		coll.add("bs");
		coll.add("ctrtr");
		coll.add("ddssad");
		
//		Iterator it = coll.iterator();
//		
//		while(it.hasNext())
//		{
//			System.out.println(it.next());
//		}
		/**
		 * 节约内存
		 */
		for (Iterator iterator = coll.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next().toString().length());
			
		}
//		
	}
	
}
