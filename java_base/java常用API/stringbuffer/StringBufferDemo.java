package cn.copper.stringbuffer;

public class StringBufferDemo {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		sb.append(1);
		sb.append("aaa");
//		sb.append(665555);
//		sb.append(true);
//		sb.insert(1, "b");
//		sb.delete(3, 11);
		
		sb.replace(1, 4, "bbb");
		
		String s = sb.toString();
		
		System.out.println(s);
	}
	
}
