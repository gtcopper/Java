package cn.copper.basic;

import java.text.NumberFormat;

import org.junit.Test;
/**
 * 静态工厂方法
 * @author Administrator
 *
 */
public class NumberFormatDemo {

	@Test
	public void test4() {
		NumberFormat currentFormatter = NumberFormat.getCurrencyInstance();
		NumberFormat percentFormatter = NumberFormat.getPercentInstance();
		double x = 0.1;
		System.out.println(currentFormatter.format(x));
		System.out.println(percentFormatter.format(x));
	}
	
}
