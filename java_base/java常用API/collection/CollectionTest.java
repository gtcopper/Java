package cn.copper.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest {

	public static void main(String[] args) {
		
		
		Collection coll = new ArrayList();
		
		Person p = new Person();
		p.setName("aaa");
		p.setAge(18);
		
		coll.add(p);
		coll.add(p);
		coll.add(new Person("bbb",19));
		coll.add(new Person("bbb",19));
		coll.add(new Person("ccc",20));
		
		for(Iterator it = coll.iterator();it.hasNext();)
		{
			Person p2 = (Person)it.next();
			System.out.println(p2.getName()+" " + p2.getAge());
		}
		
	}
	
}
