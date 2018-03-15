package cn.copper.basic;

import java.math.BigInteger;
import java.util.Scanner;

import org.junit.Test;

public class ForDemo {

	@Test
	public void test() {
		
		Scanner in = new Scanner(System.in);
		System.out.printf("How many numbers you need to draw?");
		int k = in.nextInt();
		
		System.out.printf("What's the highest number you can draw?");
		int n = in.nextInt();
		
		if(n<k) System.out.println("非法输入!!,n必须大于k");

		int lotteryOdds = 1;
		for(int i=1;i<=k;i++) {
			lotteryOdds = lotteryOdds*(n-i+1)/i;
		}
		System.out.println(lotteryOdds);
		in.close();
	}
	/**
	 * 测试for循环大数值
	 */
	@Test
	public void test2() {
		
		Scanner in = new Scanner(System.in);
		System.out.printf("How many numbers you need to draw?");
		int k = in.nextInt();
		
		System.out.printf("What's the highest number you can draw?");
		int n = in.nextInt();
		
		if(n<k) System.out.println("非法输入!!,n必须大于k"); 
		
		BigInteger lotteryOdds = BigInteger.valueOf(1);
		for(int i=1;i<=k;i++) {
			lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n-i+1)).divide(BigInteger.valueOf(i));
		}
		System.out.println(lotteryOdds);
		in.close();
	}
}
