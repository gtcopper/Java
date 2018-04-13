package cn.copper.io;

import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamDemo {

	public static void main(String[] args) throws IOException {
		
		FileInputStream in = new FileInputStream("tempFile\\file.txt");
		int ch =  0;
		while((ch = in.read())!=-1)
		{
			System.out.println("ch = " +(char) ch);
			//System.out.println(ch = in.read());
		}
		in.close();
	}
	
}
