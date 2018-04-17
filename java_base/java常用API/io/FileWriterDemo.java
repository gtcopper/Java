package cn.copper.io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

	public static void main(String[] args) throws IOException {
		
		
		FileWriter writer = new FileWriter("tempFile\\test.txt",true);//不存在文件会自动创建
		
		writer.write("dsdsa");//写入到缓冲区中
		
		writer.flush();//刷新缓冲区，将缓冲区的数据写入到文件中
		
		writer.close();//关闭写入字符流时，会先进行刷新缓冲区(自动调用flush()方法)
		
	}
	
}
