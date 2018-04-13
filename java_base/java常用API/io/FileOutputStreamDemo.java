package cn.copper.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");//系统的换行符

	public static void main(String[] args) throws IOException {
	
		File dir = new File("tempFile");
		if(!dir.exists())
		{
			dir.mkdir();
		}
		File file = new File(dir,"file.txt");
		FileOutputStream out = new FileOutputStream(file,true);//第二个参数，是否续写
		
		byte[] data = "abcdef".getBytes();
		out.write(data);
		
		String str = LINE_SEPARATOR+"aaa";
		out.write(str.getBytes());//windows 换行\r
		out.close();
		
	}
	
	
}
