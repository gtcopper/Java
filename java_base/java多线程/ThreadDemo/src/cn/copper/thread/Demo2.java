package cn.copper.thread;
/**
 * 实现Runnable接口
 * @author Administrator
 *
 */
public class Demo2 {

	public static void main(String[] args) {
		//不是线程对象
		ThreadDemo2 d1 = new ThreadDemo2("aaa");
		Thread t1 = new Thread(d1);
		Thread t2 = new Thread(d1);
		t1.start();
		t2.start();
	}
	
}
