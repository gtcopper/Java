package cn.copper.io;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

public class FileMethodDemo {

	public static void main(String[] args) {
		
		File file = new File("H:\\test.txt");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getPath());//根据所输入的文件路径所改变，即相对路径显示相对路径，反之显示绝对路径
		System.out.println(file.getName());
		System.out.println(file.length());
		System.out.println(file.getFreeSpace());
		System.out.println(new Date(file.lastModified()).toLocaleString());
		System.out.println(DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG).format(new Date(file.lastModified())));
		
		
	}
	
}
