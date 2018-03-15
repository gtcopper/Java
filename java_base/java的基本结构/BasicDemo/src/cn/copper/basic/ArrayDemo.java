
package cn.copper.basic;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class ArrayDemo {

	@Test
	public void test() {
		
		int[] i = {1,2,3,4,5};
		System.out.println(Arrays.toString(i));
		
	}
	/**
	 * 拷贝数组发一
	 */
	@Test
	public void test2() {
		int[] i = {1,2,3,4,5};
		int[] n;
		n=i;
		n[4] = 10;
		System.out.println(Arrays.toString(i));
		System.out.println(Arrays.toString(n));
	}
	/**
	 * 拷贝数组法二:Arrays.copyOf()
	 */
	@Test
	public void test3(){
		int[] i ={1,2,3,4,5};
		int[] n = Arrays.copyOf(i, 6);
		System.out.println(Arrays.toString(n));//超出长度，其余值赋值为0;
	}
	
	/**
	 * 数组排序Arrays.sort()优化的快速排序算法
	 */
	@Test
	public void test4() {
		Scanner in = new Scanner(System.in);
		System.out.printf("How many numbers you need to draw?");
		int k = in.nextInt();
		
		System.out.printf("What's the highest number you can draw?");
		int n = in.nextInt();
		
		if(n<k) System.out.println("非法输入!!,n必须大于k");
		
	
		int[] numbers = new int[n];
		//将数组的值从0赋到n
		for(int i=0;i<numbers.length;i++) {
			numbers[i] = i;
		}
		//保存结果
		int result[] = new int[k];
		
		for(int i = 0;i<result.length;i++) {
			
			int r = (int)(Math.random()*n);
			
			result[i] = numbers[r];
			
			//为保证数值的唯一性,将numbers[]最后元素的随机赋值到其他位置
			numbers[r] = numbers[n-1];
			n--;
			
		}
		Arrays.sort(result);
		for(int i : result) {
			System.out.println(i);
		}
		in.close();
		
	}
}
