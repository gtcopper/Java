package cn.copper.io;

import java.io.File;

public class FileDemo {

	//文件分割符
	private static final String FILE_SEPARATOR = System.getProperty("file.separator");

	public static void main(String[] args) {
		
		String pathName = "D:\\file.txt";
		File file = new File(pathName);
		System.out.println(file);
		
		File p = new File("D:"+FILE_SEPARATOR+"java");
		File p2 = new File(p,"file.txt");
		System.out.println(p2);
		
		//文件分隔符
		File p3 = new File("D:"+File.pathSeparator+"java");
		File p4 = new File(p,"file.txt");
		System.out.println(p2);
		
	}
	
}
