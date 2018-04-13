package cn.copper.io;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

public class FileMethodDemo3 {

	public static void main(String[] args) {
		
		/**
		 * 给定目录获取内容
		 */
		File dir = new File("e:\\sharing");
		//需要做健壮性判断，1.必须存在，2.必须是目录,否则容易引发空指针异常
		String[] list = dir.list();//获取目录下的文件夹及文件名称
		for(String s : list)
		{
			//System.out.println(s);
		}
		
		File[] files = dir.listFiles();
		for(File f : files)
		{
			System.out.println(DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG).format(new Date(f.lastModified())));
		}
		
	}
}
