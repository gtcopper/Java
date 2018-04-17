package cn.copper.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;


public class TransStreamDemo {

	public static void main(String[] args) throws IOException{
		WriteToFile();
		ReadToFile();
	}

	public static void ReadToFile() throws IOException{
		
		InputStreamReader isr = new InputStreamReader(new FileInputStream("tempFile\\test2.txt"),"utf-8");
		
//		int ch = isr.read();
//		
//		System.out.println((char)ch);
//		
		int len = 0;
		
		char[] c = new char[1024];
		String str = null;
		
		while((len = isr.read(c)) != -1)
		{
			str = new String(c,0,len);
		}
		
		System.out.println(str);
		
		isr.close();
		
	}

	private static void WriteToFile() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		/**
		 * 转换中文码表有GBK，UTF-8，需要将数据进行转码
		 * 不能使用FileWriter构造方法进行默认解码，写入数据
		 */
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("tempFile\\test2.txt"), "utf-8");
		
		osw.write("我来了");
		
		osw.flush();
		
		osw.close();
	}

}
