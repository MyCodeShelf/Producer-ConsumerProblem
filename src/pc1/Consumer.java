package pc1;

import java.util.ArrayList;

public class Consumer implements Runnable
{
ArrayList<Integer> stocked =new ArrayList<>();
public Consumer(ArrayList<Integer> stocked) {
	// TODO Auto-generated constructor stub
	this.stocked=stocked;
}

@Override
public void run() {
	// TODO Auto-generated method stub
	while(true)
	{
	try
	{
	consumer();
	}
	catch(InterruptedException e)
	{
		e.printStackTrace();
	}}
}
private void consumer() throws InterruptedException
{
	synchronized (stocked) {  
        while (stocked.size() == 0) {  
             System.out.println("Queue is empty");  
             stocked.wait();
}
}
	synchronized (stocked) {  
      //  Thread.sleep(1000);  
        System.out.println("Consumed :" +stocked.remove(0));  
        stocked.notify(); 
	}
	}
}