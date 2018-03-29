package cn.copper.thread;

public class Productor implements Runnable {

	Resource r ;
    Productor(Resource r)
    {
    	this.r = r;
    }
	
    public void run()
    {
    	while(true)
	    	{
	    		r.setName("面包");    		
	    	}
    }
    
}
