package cn.copper.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		
		/**
		 * 去除字符串中重复元素
		 */
		Set set = new HashSet();
		
		//set.add(new Person("aaa",12));
//		set.add("aaa");
//		set.add("bbb");
//		set.add("ccc");
//		set.add("aaa");
		
		/**
		 * 新建对象都有自己的hash值,故不相同，不需要判断equals方法
		 * 不能使用Object的hashCode方法，需要自定义方法覆盖
		 */
		set.add(new Person("aaa",12));
		set.add(new Person("bbb",12));
		set.add(new Person("aaa",12));
		set.add(new Person("aaa",13));
		
		for (Iterator it = set.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
		
	}
	
}
