package cn.copper.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List解決插入元素的問題
 * @author Administrator
 *
 */
public class ListDemo {

	
	public static void main(String[] args) {
		
		List l = new ArrayList();
		
		l.add(new Person("bbb",19));
		l.add(new Person("bbb",19));
		l.add(new Person("ccc",20));
		
		l.add(1,new Person("ggg",20) );
		
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
		
		for (Iterator it = l.iterator(); it.hasNext();) {
			Person p = (Person) it.next();
			System.out.println(p);
			
		}
		
		
	}
}
