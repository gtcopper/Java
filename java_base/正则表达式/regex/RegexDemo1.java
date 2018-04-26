package cn.copper.regex;

import java.util.Iterator;

import org.junit.Test;

public class RegexDemo1 {

	@Test
	public void test1(){
		
		String text = "13546298911";
		String regex = "1[3,5,8]\\d{9}";
		
		boolean b = text.matches(regex);
		System.out.println("text:" + b);
		
	}
	
	@Test
	public void test2()
	{
		
		String text ="aaa    bbb            ccc";
		String regex = " +";
		
		String[] ss =  text.split(regex);
		
		for(String s : ss){
			System.out.println(s);
		}
		
	}
	
	/*
	 * 正则封装用(),便于正则的复用，有编号，从1开始,称为组,通过编号调用对应的组
	 */
	@Test
	public void test3(){
		String text = "abcccdeeef";
		String regex ="(.)\\1+";//调用需要转义，调用已有的第一组
		String[] ss = text.split(regex);
		for (String s : ss) {
			System.out.println(s);//将叠词作为分隔符
		}
	}
	
}
