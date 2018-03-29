package cn.copper.thread;
/**
 * 继承Thread类
 * @author Administrator
 *
 */
public class ThreadDemo1 extends Thread {

	private String name;
	public ThreadDemo1(String name) 
	{
		this.name = name;
	}
	
	public void run() 
	{
		for(int i=1;i<=20;i++)
		{
			System.out.println("name = "+name+" i = " +i+" ThreadName = "+Thread.currentThread().getName()+"");
		}
	}
	
}
