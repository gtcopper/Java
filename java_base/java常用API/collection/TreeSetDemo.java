package cn.copper.collection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		
		Set set =  new TreeSet();
		
//		set.add("aaa");
//		set.add("ccc");
//		set.add("bbb");
		/**
		 * TreeSet add 方法底层实现
		 * 需将元素转成Comparable类型,以实现排序功能
		 * 比较类需要实现Comparable接口
		 */
		set.add(new Person("aaa",12));
		set.add(new Person("adsd",12));
		set.add(new Person("bbb",13));
		set.add(new Person("aaa",14));
		
		for (Iterator it = set.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
		
	}
	
}
