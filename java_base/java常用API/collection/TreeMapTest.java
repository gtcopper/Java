package cn.copper.collection;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		
		TreeMap<Student,String> map = new TreeMap<Student,String>();
		map.put(new Student("aaa",18), "香港");
		map.put(new Student("bbb",20), "广州");
		map.put(new Student("ddd",21), "深圳");
		map.put(new Student("ccc",21), "杭州");
		map.put(new Student("ccc",21), "山东");//存入重复的键值对，由后面存入的覆盖前面存入的
		
		for(Map.Entry<Student, String> entry : map.entrySet())
		{
			Student s = entry.getKey();
			String value = entry.getValue();
			System.out.println(s + " = " +value);
		}
		
	}
	
}
