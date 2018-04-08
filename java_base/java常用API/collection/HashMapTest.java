package cn.copper.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		
		HashMap<Student,String> map = new HashMap<Student,String>();
		map.put(new Student("aaa",18), "香港");
		map.put(new Student("bbb",20), "广州");
		map.put(new Student("ddd",21), "深圳");
		map.put(new Student("ddd",21), "北京");
		map.put(new Student("ccc",21), "杭州");
		
		
		for(Map.Entry<Student, String> entry : map.entrySet())
		{
			Student s = entry.getKey();
			String v = entry.getValue();
			System.out.println(s + " = " + v);
		}
		
	}
	
}
