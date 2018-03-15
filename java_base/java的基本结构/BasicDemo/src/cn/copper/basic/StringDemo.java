package cn.copper.basic;

import org.junit.Test;

public class StringDemo {

	@Test
	public void test() {
		String greeting = "hello";
		String s = greeting.substring(0,2);//左包右不包,字符串长度:右边参数-左边参数
		System.out.println(s);
	}
	@Test
	public void test2() {
		StringBuffer sb = new StringBuffer();
		sb.append("gtcopper");
		sb.append("t");
		
		System.out.println(sb.toString());
	}
}
