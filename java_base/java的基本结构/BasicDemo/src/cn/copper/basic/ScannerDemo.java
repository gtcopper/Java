package cn.copper.basic;

import java.io.Console;
import java.util.Scanner;

import org.junit.Test;

public class ScannerDemo {
  
	/**
	 * Scanner类的相关用法
	 */
	
	@Test
	public void test() {
		
		Scanner in = new Scanner(System.in);
		//读取缓冲区一行内容
		System.out.println("Hello, what's your name?");
		String name = in.nextLine();
		//读取整数
		System.out.println("How old are you?");
		int age = in.nextInt();
		
		System.out.println("Hello, "+name+" ,next year you will be " +(age+1));
		//读取一个字符，以空格为分隔符
		System.out.println("测试读取一个字符:");
		String c = in.next();
		System.out.println(c);
		
	}
	/**
	 * 输入控制台的东西是显示的，要想不显示，使用Console这个类
	 * 注意:语句本身是没有错的。问题的关键是这段代码若是在eclipse的运行就会有问题，而如果你用命令行的方式，先编译后运行就没有问题了。
	 */
	@Test
	public void test2() {
		Console cs = System.console();
		
		if(cs == null) {
			System.out.println("输入不能为空: ");
			return;
		}
		
		String name = cs.readLine("User name :");
		System.out.println(name);
		char[] password = cs.readPassword("Password : ");
		System.out.println(cs);
		
	}
	
}
