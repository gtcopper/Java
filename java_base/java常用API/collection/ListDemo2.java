package cn.copper.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo2 {

	public static void main(String[] args) {
		
		List list = new ArrayList();
		
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		//Iterator it = list.iterator();
		//列表迭代器，可以进行CRUD操作
		ListIterator it = list.listIterator();
		
		while(it.hasNext())
		{
			
			Object obj = it.next();
			if("bbb".equals(obj))
			{
				//通过迭代对象的方法添加
				//it.add("ddd");
				it.set("ggg");
			}
			
		}
		
		System.out.println(list);
	}
	
}
