package cn.copper.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) throws IOException {
		
		
		FileOutputStream out = new FileOutputStream("tempFile\\cn.txt");
		
		FileInputStream in = new FileInputStream("tempFile\\cn.txt");
		
		writeToFile(out);
		
		readToFile(in);
		
	}

	public static void readToFile(FileInputStream in) throws IOException {
	
		
		int len = 0;
		byte[] buffer = new byte[1024];
		
		String str = null;
		
		while((len = in.read(buffer)) != -1)
		{
			str = new String(buffer,0,len);
		}
		
		int j =0;
		
		for(int x = str.indexOf("好");x!=-1;x = str.indexOf("好",x+"好".length()))
		{
			j++;
		}
		
		System.out.println(j);
		System.out.println(str);
	}

	public static void writeToFile(FileOutputStream out) throws IOException {
	
		out.write("你好你好你好你好你好你好你好你好!!".getBytes());
		
		out.close();
		
	}
	
}
