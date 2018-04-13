package cn.copper.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamDemo2 {

	public static void main(String[] args) throws IOException {

		File file = new File("tempFile\\file.txt");
		FileInputStream in = new FileInputStream(file);
	
		byte[] buffer =new byte[1024];//定义为1024的整数倍
		
		int len = 0;
		
		while((len = in.read(buffer))!= -1)
		{
			System.out.println(new String(buffer,0,len));
		}
		
//		int i = in.read(buffer);
//		
//		System.out.println(i);
//		
//		System.out.println(new String(buffer));
		
		in.close();
	}

}
