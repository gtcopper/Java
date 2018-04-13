package cn.copper.io;

import java.io.File;

public class FileMethodDemo4 {

	public static void main(String[] args) {
		
		/**
		 * 获取目录中的文件，只包含.java的文件
		 */
		File dir = new File("E:\\");
//		String[] files =  dir.list();
//		for(String s : files)
//		{
//			System.out.println(s);
//		}
		
		File[] files = dir.listFiles(new FileNameFilterBySuffix(".pdf"));//需要传入文件名过滤器FileNameFilter
		
		for(File f : files)
		{
			
//			if(f.getName().endsWith(".java"))
//			{
				System.out.println(f.getName());
			//}
		}
	}
	
	
}
