package cn.copper.thread;

public class Customer implements Runnable {
	Resource r ;
    Customer(Resource r)
    {
    	this.r = r;
    }
    
    public void run()
    {
    	while(true)
	    	{
	    		r.getName();    		
	    	}
    }
	
}
