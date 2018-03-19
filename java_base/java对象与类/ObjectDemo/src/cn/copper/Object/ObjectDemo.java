package cn.copper.basic;

import org.junit.Test;

/**
 * 测试Object类的方法
 * @author Administrator
 *
 */
public class ObjectDemo {

	@Test
	public void test() {
		Object o =new Object();
		Object b = new Object();
		System.out.println(o.getClass().getName());
		boolean c =  o.equals(b);
		System.out.println(c);
		int i = o.hashCode();
		int n = b.hashCode();
		System.out.println("i = "+i+ " n = "+n);
	}
	
}
