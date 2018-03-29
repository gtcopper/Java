package cn.copper.thread;
/**
 * 多生产多消费
 * @author Administrator
 *
 */
public class ResourceDomain {

	private String name;
	private int code = 1;
	public  boolean flag = false;//用来判断商品是否被消费
	
	//public static final Object obj = new Object();
	
	public synchronized void setName(String name){
		if(flag)
		{
			try {
				wait();//当前线程等待
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			this.name = name+code;
			code++;
		System.out.println(Thread.currentThread().getName()+"...生产了..."+this.name);
		flag = true;
		notify();//唤醒消费者线程
	}
	
	public synchronized void getName(){
		if(!flag)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"...消费了..."+this.name);
		flag = false;
		notify();
	}
	
}
