package cn.copper.stringbuffer;

import org.junit.Test;

public class StringBufferTest {

	@Test
	public void test1()
	{
		int[] n = {1,2,3,4};
		//String str = toString_1(n);//字符串拼接
		
		String str = toString_2(n);
		System.out.println(str);
	}

	/**
	 * 字符串拼接
	 * @param n int数组
	 * @return String
	 */
	public String toString_1(int[] n) {
		String str ="[";
		for(int i=0;i<n.length;i++)
		{
			if(i!=n.length-1)
			{
				str+=n[i]+",";
			}
			else
			{
				str+=n[i]+"]";
			}
		}
		return str;
	}
	
	/**
	 * StringBuffer填充
	 *@param n int数组
	 * @return String
	 */
	
	public String toString_2(int[] n) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i=0;i<n.length;i++)
		{
			if(i!=n.length-1)
			{
				sb.append(n[i]);
				sb.append(",");
			}
			else
			{
				sb.append(n[i]);
				sb.append("]");
			}
		}
		return sb.toString();
	}
	
}
