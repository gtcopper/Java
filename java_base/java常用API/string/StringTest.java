package cn.copper.string;

import java.util.Arrays;

import org.junit.Test;

public class StringTest {

	/**
	 * 字符串数组从小到大排序
	 */
	@Test 
	public void test1()
	{
		String[]  strs= {"abc","rfr","jhu","sad"};
		

		for(String s : strs)
		{
			System.out.print(s+"  ");
		}
		System.out.println();
		sortString(strs);
		
		for(String s : strs)
		{
			System.out.print(s+"  ");
		}
		System.out.println();
	}

	/**
	 * 字符串数组排序
	 * @param strs
	 */
	public static void sortString(String[] strs) {
		
		for(int i =0;i<strs.length-1 ;i++)
		{
			for (int j = i+1; j < strs.length; j++) {
				if(strs[i].compareTo(strs[j])>0)
				{
					String temp;
					temp = strs[i];
					strs[i] = strs[j];
					strs[j] = temp;
				}
			}
		}
		
		//Arrays.sort(strs);
		
	}
	/**
	 * 字符串出线的次数
	 */
	@Test
	public void test2() 
	{
		String str = "aaabbaaabbbrrraaaaeeehhhhaaarrvvxsaaaffffaaadfdfaaaa";
		String key = "aaa";
//		
//		int x = str.indexOf(key);
//		System.out.println(x);
//		
//		int y =str.indexOf(key,x+key.length());
//		System.out.println(y);
		
		
		System.out.println(getCount(str,key));
		
	}
	/**
	 * 返回字符串中某字符串出现的次数
	 * @param str 原字符串
	 * @param key 匹配的字符串
	 * @return 出线的次数
	 */
		public int getCount(String str,String key){
		int count =0;
		for(int x = str.indexOf(key);x!=-1;x = str.indexOf(key,x+key.length()))
		{
			count++;
		}
		    return count;
	}
		/**
		 * 將字符串長度由長到短打印
		 */
		@Test
		public void test3()
		{
			String str = "i_am_coming!";
			PrintStringBylength(str);
		}

		/**
		 * 將字符串長度由長到短打印
		 * @param str
		 */
		public void PrintStringBylength(String str) {
			
			for(int x=0;x<str.length();x++)
			{
				for(int y =0,z = str.length()-x;z<=str.length();y++,z++)
				{
					 System.out.printf("  "+str.substring(y,z)+"  ");
				}
				System.out.println();
			}
		}
		/**
		 * 9x9算法
		 */
	@Test
	public void test4()
	{
		for(int i=1;i<=9;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(j+"x"+i+" = " +i*j+" ");
			}
			System.out.println();
		}
	}
	
}
