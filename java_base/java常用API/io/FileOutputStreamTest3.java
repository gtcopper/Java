package cn.copper.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileOutputStreamTest3 {

	private static final String LINE_SEPARTOR = SeparatorTool.LINE_SEPARATOR;

	public static void main(String[] args) {
		
		/**
		 * 获取指定目录下的所有.java文件
		 * 并将文件的绝对路径写入到指定文件中
		 * 使用过滤器完成
		 */
		
		File dir = new File("e:\\sharing");
		
		FileFilter filter = new FileFilterBySuffix(".java");
		
		List<File> list = new ArrayList<File>();
		
		//FileOutputStream out = new FileOutputStream();
		
		//获取指定文件清单
		getFileList(dir,filter,list);
		
		//System.out.println(list.size());
		
		File destFile = new File("tempFile\\javaURL.txt");
		writeToFile(list,destFile);
		
	}

	public static void writeToFile(List<File> list, File destFile) {
		
		FileOutputStream out = null;
		BufferedOutputStream bfops = null;//定义流缓冲区,加快写入文件的速度
		try {
			out = new FileOutputStream(destFile);
			bfops = new BufferedOutputStream(out);
			for(File f : list){
				String info = f+LINE_SEPARTOR;
				bfops.write(info.getBytes());
				bfops.flush();//每写入一个绝对路径刷新一次
			}
		}catch(IOException e)
		{
			
		}finally{
			if(bfops != null)
			{
				try {
					out.close();
				}catch(IOException e)
				{
					throw new RuntimeException("关闭资源遇到错误.....");
				}
			}
		}
		
	}

	public static void getFileList(File dir,FileFilter filter,List<File> list) {
		
		File[] files = dir.listFiles();
		FileOutputStream out = null;
		
		for(File file : files)
		{
			if(file.isDirectory())
			{
				getFileList(file,filter,list);
			}
			else
			{
				if(filter.accept(file))
				{
					list.add(file);
				}
			}
		}
		
	}
	
}
