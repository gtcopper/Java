package cn.copper.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

import org.junit.Test;

public class FileDemo {

	@Test
	public void test() throws IOException {
		//使用Scanner类读取文件
				Scanner sc = new Scanner(Paths.get("H:\\test.txt"),"UTF-8");
				while(sc.hasNext()) {
					System.out.println(sc.next());
				}
				sc.close();
	}
		@Test
		public void test2() throws IOException {
		//PrintWriter写入文件,不存在就创建
			
		PrintWriter out = new PrintWriter("test.txt","UTF-8");
		out.println("I ");
		out.println("am");
		out.println("comming!!!");
		out.close();
		
		Scanner s = new Scanner(Paths.get("test.txt"),"UTF-8");
		while(s.hasNext()) {
			System.out.println(s.next());
		}
		
		s.close();
		
	}
}
