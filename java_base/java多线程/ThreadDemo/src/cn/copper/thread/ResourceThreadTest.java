package cn.copper.thread;

public class ResourceThreadTest {

	public static void main(String[] args) {
		
		Resource r = new Resource();
		
		Productor pd = new Productor(r);
		Customer ct = new Customer(r);
		
		Thread t1 = new Thread(pd);
		Thread t2 = new Thread(ct);
		
		
		
		t1.start();
		t2.start();
		
		
	}
	
}
