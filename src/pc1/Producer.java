package pc1;

import java.util.ArrayList;

public class Producer implements Runnable {
	ArrayList<Integer> stocked =new ArrayList<>();
	public Producer(ArrayList<Integer> stocked) {
		// TODO Auto-generated constructor stub
		this.stocked=stocked;
	}
public void run()
{
	for(int i=0;i<5;i++)
	{ try
	{
	
		produce(i);
	}
			catch(InterruptedException e)
	{
	e.printStackTrace();
	}
}
}
private void produce(int i) throws InterruptedException
{
	synchronized (stocked) {
		if(stocked.size()==1)
		{
			System.out.println("Queue Full");
		stocked.wait();
	}
	}
	synchronized (stocked) {
		System.out.println("Produced : "+i);  
        stocked.add(i);  
     //   Thread.sleep(1000);  
        stocked.notify(); //It will notify the consumer thread
	}
}
}
