package cn.copper.thread;
/**
 * 售票例子
 * @author Administrator
 *
 */
public class Ticket implements Runnable {

	private int tickets = 100;
	
	private Object object = new Object();
	//多线程任务中通常都有循环结构
	public void run() 
	{
		while(true)
		{
			sale();
		}
	}
	
	public synchronized void sale()
	{
		if(tickets > 0)
		{
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(Thread.currentThread().getName()+"----"+tickets--);
		}
	}
	
}
