package cn.copper.basic;

import java.util.Date;

import org.junit.Test;

/**
 * 格式化输出
 * @author Administrator
 *
 */
public class FormatDemo {

	@Test
	public void test() {
		
		double x = 10000.0/3.0;
		System.out.println(x);
		//浮点格式化
		System.out.printf("%8.2f"+ "\n",x);
		System.out.printf("%,.2f"+"\n",x);
		System.out.printf("%tc",new Date());
	}
	
}
