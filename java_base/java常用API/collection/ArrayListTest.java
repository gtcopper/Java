package cn.copper.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		
		/**
		 * 删除List容器中重复的元素
		 */
		List<Person> list = new ArrayList<Person>();
//		list.add("aaa");
//		list.add("bbb");
//		list.add("ccc");
//		list.add("aaa");
//		list.add("bbb");
		
		list.add(new Person("aaa",12));
		list.add(new Person("bbb",12));
		list.add(new Person("aaa",12));
		list.add(new Person("aaa",13));
		
		getSingleElement(list);
		
		System.out.println(list);
		
	}
	
	public static List<Person> getSingleElement(List<Person> list)
	{
		List<Person> temp = new ArrayList<Person>();
		for (Iterator<Person> it = list.iterator(); it.hasNext();) 
		{
			Person p = it.next();
			if(!temp.contains(p))//contains判断用是equals方法
			{
				temp.add(p);
			}
			
		}
		
		list.clear();//清空容器中全部元素
		list.addAll(temp);
		return list ;
	}
	
}
