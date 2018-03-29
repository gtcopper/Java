package cn.copper.thread;

public class ThreadDemo2 implements Runnable {

	
	private String name;
	
	ThreadDemo2(String name)
	{
		this.name = name;
	}
	/**
	 * 覆盖Runnable接口run方法
	 */
	public void run() {
		for(int i=1;i<=20;i++)
		{
			System.out.println("name = "+name+" i = " +i+" ThreadName = "+Thread.currentThread().getName()+"");
		}
		
	}

}
