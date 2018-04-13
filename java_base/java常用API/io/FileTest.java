package cn.copper.io;

import java.io.File;

public class FileTest {

	/**
	 * 列出当前目录下的子目录下的所有内容
	 * @param args
	 */
	public static void main(String[] args) {
		
		File dir = new File("e:\\sharing");
		listAll(dir);
	}
	
	public static void listAll(File dir)//接收目录及子目录
	{
		System.out.println("dir: "+ dir);
		File[] files = dir.listFiles();
		for(File f1 : files)
		{
			if(f1.isDirectory())
			{
				listAll(f1);//文件层级过深，可能导致栈溢出
			}
			System.out.println("file: "+f1.getName());
		}
		
	}
	
}
