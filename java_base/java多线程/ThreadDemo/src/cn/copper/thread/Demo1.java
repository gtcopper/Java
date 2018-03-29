package cn.copper.thread;

public class Demo1 {

	public static void main(String[] args) {
		ThreadDemo1 d1 = new ThreadDemo1("aaa");
		ThreadDemo1 d2 = new ThreadDemo1("bbb");
		d2.start();//先开启线程，主线程与当前线程同时执行，并发执行
		d1.run();
		
	}
	
}
