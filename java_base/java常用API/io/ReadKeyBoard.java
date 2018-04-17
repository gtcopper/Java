package cn.copper.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadKeyBoard {

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("tempFile\\keyin.txt",true));
		
		String line = null;
		
		while((line = br.readLine()) != null )
		{
			if("over".equals(line))
			{
				break;
			}
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		
		bw.close();
		
	}
	
}
