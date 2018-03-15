package cn.copper.basic;

import org.junit.Test;

public class BooleanDemo {

	/**
	 * Type mismatch: cannot convert from int to boolean
	 * java中boolean与整型数据不能相互转换；
	 */
	@Test
	public void test(){
		int x = 5;
		//if(x=0) {//不能通过编译
			System.out.println("....");
	}
	/**
	 * 测试精度问题
	 */
	@Test
	public void test2() {
		int i =123456789;
		int o = 300;
		byte b ;
		b = (byte)o;
		float f = i;
		double d = i;
		System.out.println(f);
		System.out.println(d);
		System.out.println(b);
	}
	
	/**
	 * 枚举
	 */
	enum Size {SMALL,MEDIUM,LARGE,BIG_LARGE};
	@Test
	public void test3(){
		Size s = Size.SMALL;
		System.out.println(s);
	}
}
