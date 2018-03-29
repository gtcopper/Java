package cn.copper.thread;

/**
 * 死锁的一种情况
 * 线程任务中有多个同步锁，一个同步锁中嵌套另一个同步锁
 * @author Administrator
 *
 */
public class DeadLock implements Runnable {

	private boolean flag;
	
	DeadLock(boolean flag)
	{
		this.flag = flag;
	}
	
	public void run()
	{
		if(flag)
		{
			while(true)
			{
				synchronized(MyLock.Lock1)
				{
					System.out.println(Thread.currentThread().getName()+"...if...Lock1");
					synchronized(MyLock.Lock2)
					{
						System.out.println(Thread.currentThread().getName()+"...if...Lock2");
					}
				}
			}
		}
		else
		{
			while(true)
			{
				synchronized(MyLock.Lock2)
				{
					System.out.println(Thread.currentThread().getName()+"...else...Lock1");
					synchronized(MyLock.Lock1)
					{
						System.out.println(Thread.currentThread().getName()+"...else...Lock2");
					}
				}
			}
		}
	}
	
}
