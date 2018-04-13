package cn.copper.io;

import java.io.File;
import java.util.LinkedList;
/**
 * 队列实现获取指定目录下的所有内容
 * @author Administrator
 *
 */
public class GetAllFile {

	public static void main(String[] args) {
		
		/**
		 * 不用递归遍历文件夹,使用队列实现
		 */
		File dir = new File("e:\\sharing\\src");
		File[] files = dir.listFiles();
		Queue<File> q = new Queue<File>();
		for(File f : files)
		{
			if(f.isDirectory())
			{
				q.add(f);
			}else {
				System.out.println(f.getName());
			}
		}
		
		System.out.println("------------");
		
		while(!q.isEmpty())
		{
			File subDir = q.get();//从队列中取出子目录
			System.out.println(subDir.getName());
			File[] subFiles = subDir.listFiles();
			for(File f2 : subFiles)
			{
				if(f2.isDirectory())
				{
					q.add(f2);
				} else {
					System.out.println(f2.getName());
				}
			}
		}
		
	}
	
}

class Queue<E> {
	
	private LinkedList<E> link;
	
	Queue()
	{
		link = new LinkedList<E>();
	}
	
	public void add(E obj)
	{
		link.addFirst(obj);
	}
	
	public E get()
	{
		return link.removeLast();
	}
	
	public boolean isEmpty()
	{
		return link.isEmpty();
	}
	
}
