package cn.copper.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class CollectionDemo {

	public static void main(String[] args) {

		Collection coll = new Vector();
		Collection coll2 = new ArrayList();
		CollectionDemo(coll,coll2);
	}

	public static void CollectionDemo(Collection coll,Collection coll2) {
		
		//添加元素
		coll.add("aaa");
		coll.add("bbb");
		
		coll2.add(1);
		coll2.add(2);
		
		System.out.println(coll);
		//删除
		boolean b = coll.remove("aaa");
		System.out.println(b+""+coll);
		
		boolean b2 =coll.contains("bbb");
		System.out.println(b2);
		
		coll.addAll(coll2);
		System.out.println(coll);
		
	}

}
