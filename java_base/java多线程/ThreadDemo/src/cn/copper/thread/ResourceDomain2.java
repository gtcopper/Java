package cn.copper.thread;
/**
 * 一对一消费
 * @author Administrator
 *
 */
public class ResourceDomain2 {

	private String name;
	private int code = 1;
	public  boolean flag = false;//用来判断商品是否被消费
	
	//public static final Object obj = new Object();
	
	public synchronized void setName(String name){
		while(flag)//if改为while判断，必须多判断标记，否侧出线线程问题
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
		notifyAll();//唤醒所有线程，防止出现死锁
	}
	
	public synchronized void getName(){
		while(!flag)
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
		notifyAll();
	}
	
}
