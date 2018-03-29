package cn.copper.thread;

public class ThreadDemo3 {

	public static void main(String[] args) {
		
		Ticket tk = new Ticket();
		Thread t1 = new Thread(tk);
		Thread t2 = new Thread(tk);
		Thread t3 = new Thread(tk);
		Thread t4 = new Thread(tk);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
	
}
