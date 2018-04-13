package cn.copper.io;

import java.io.File;
import java.io.IOException;

public class FileMethodDemo2 {

	public static void main(String[] args) throws IOException {
		
		/**
		 * 对文件进行操作
		 */
		
		File file = new File("D:\\test.txt");
		
//		boolean b1 = file.createNewFile();//文件存在返回false，存在IOException
//		System.out.println(b1);
		
//		boolean b2 = file.delete();//不进入回收站,文件存在返回false ：文件不存在或文件正在被使用
//		System.out.println(b2);
		
//		boolean b3 = file.exists();
//		System.out.println(b3);
//		
		//对目录创建，删除，判断
		
		File file2 = new File("D:\\abc\\bbb\\ccc");//封装的是ccc这个目录
//		boolean b4 = file2.mkdir();//创建单目录，不能创建多文件夹目录
//		boolean b5 = file2.mkdirs();//创建完整路径的目录(多级目录)
//		System.out.println(b4);
//		System.out.println(b5);
		
		boolean b6 = file2.delete();//删除目录时，如果目录中有内容，无法直接删除,在该目录为空时，才可以删除
		System.out.println(b6);//
		
		System.out.println("------------");
		
		File file3  = new File("D:\\java.txt");
		file3.createNewFile();
		System.out.println(file3.isFile());//判断是文件还是目录时，需要保证文件存在
		System.out.println(file3.isDirectory());
		
		
	}
	
}
