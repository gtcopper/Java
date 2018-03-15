package cn.copper.basic;

import java.math.BigInteger;

import org.junit.Test;

public class MathDemo {

	// 返回反余弦值
	@Test
	public void test() {
		System.out.println(Math.acos(30));
	}
	//Math.addExact返回两个参数之和
	@Test
	public void test2() {
		System.out.println(Math.addExact(5, 11));
	}
	// Math.ceil向上舍入,返回大的值
	@Test
	public void test3() {
		System.out.print(Math.ceil(3.37)+" ");
		System.out.print(Math.ceil(3.11)+ " ");
		System.out.print(Math.ceil(3.01)+" ");
		System.out.print(Math.ceil(-5.33)+" ");
		System.out.println(Math.ceil(-0.07));
	}
	//Math.floor想下舍出，返回小的值
	@Test
	public void test4() {
		System.out.print(Math.floor(3.78)+" ");
		System.out.print(Math.floor(3.14)+" ");
		System.out.print(Math.floor(-3.78)+" ");
		System.out.print(Math.floor(-0.07)+" ");
	}
	 /** 
     *Math.sqrt()//计算平方根
     *Math.cbrt()//计算立方根
     *Math.pow(a, b)//计算a的b次方
     *Math.max( , );//计算最大值
     *Math.min( , );//计算最小值
     */
	@Test 
	public void test5() {
		System.out.println(Math.sqrt(4));
		System.out.println(Math.cbrt(64));
		System.out.println(Math.pow(2, 3));
		System.out.println(Math.max(5, 8));
		System.out.println(Math.min(3, 8));
	}
	/** 
     * Math.abs求绝对值 
     */
	@Test
	public void test6() {
		System.out.println(Math.abs(3.78));
		System.out.println(Math.abs(-8.666));
	}
	/** 
     * Math.random 取得一个大于或者等于0.0小于不等于1.0的随机数 
     */
	@Test
	public void test7() {
		System.out.println(Math.random());
		System.out.println(Math.random());
		System.out.println(Math.random());
	}
	 /** 
     * Math.rint 四舍五入，返回double值 
     * 注意.5的时候会取偶数  异常的尴尬
     */
	@Test
	public void test8() {
		System.out.println(Math.rint(5.33));
		System.out.println(Math.rint(5.56));
		System.out.println(Math.rint(-5.33));
		System.out.println(Math.rint(-5.66));
		System.out.println(Math.rint(6.5));// 注意.5的时候会取偶数  异常的尴尬
		System.out.println(Math.rint(3.5));
	}
	/** 
     * round 四舍五入，float时返回int值，double时返回long值 
     */
	@Test
	public void test9() {
		System.out.println(Math.round(5.3));
		System.out.println(Math.round(5.666));
		double i = 5.999;
		float n = 5.666f;
		System.out.println(Math.round(i));
		System.out.println(Math.round(n));
	}
	/**
	 * 整数大数值，任意精度,不能使用算术运算符+/*
	 */
	@Test
	public void test10() {
		BigInteger a = BigInteger.valueOf(100);
		BigInteger b = BigInteger.valueOf(200);
		BigInteger c = a.add(b);
		BigInteger d = c.multiply(b.add(BigInteger.valueOf(2)));
		System.out.println(c);
		System.out.println(d);
	}
}
