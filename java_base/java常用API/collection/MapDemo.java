package cn.copper.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("星期一", "Monday");
		map.put("星期日", "Sunday");
		
		Set<String> keySet = map.keySet();
		
		for (Iterator<String> it = keySet.iterator(); it.hasNext();) {
			String string = it.next();
			System.out.println(string+" = "+map.get(string));
		}
		
		System.out.println("--------------");
		
		for(String str : keySet)
		{
			System.out.println(str+" = "+map.get(str));
		}
		
		System.out.println("---------");
		
		Set<Entry<String,String>> entry = map.entrySet();
		
		for(Iterator<Entry<String,String>> it = entry.iterator();it.hasNext();)
		{
			Entry<String,String> entrySet =  it.next();
			String key = entrySet.getKey();
			String value = entrySet.getValue();
			System.out.println(key+" = " + value);
		}
		
		System.out.println("-----用Set实现map的增强循环-----");
		
		for(Map.Entry<String,String> e : map.entrySet())
		{
			String key = e.getKey();
			String value = e.getValue();
			System.out.println(key + " = " + value);
		}
		
		System.out.println("----返回所有键的值---");
		/**
		 * 值不需要保证唯一性
		 */
		Collection<String> c = map.values();
		System.out.println("----迭代器实现---");
		for(Iterator<String> it = c.iterator();it.hasNext();)
		{
			System.out.println(it.next());
		}
		System.out.println("--增强for实现---");
		for(String str : c)
		{
			System.out.println(str);
		}
	}
	
}
