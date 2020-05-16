package pc1;

import java.util.ArrayList;

public class PCDriver {

	public static void main(String[] args) {
		ArrayList<Integer> stocked = new ArrayList<Integer>();  
        Producer producer = new Producer(stocked);  
        Consumer consumer = new Consumer(stocked);  
        Thread p = new Thread(producer, "Producer Thread");  
        Thread c = new Thread(consumer, "Consumer Thread");  
        p.start();  
        c.start();  

	}

}
