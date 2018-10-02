
import java.util.*;

public class MessageQueue {

	private Vector<String> queue;

	private int MAX_BUFFER_SIZE = 10;

	public MessageQueue() {
		queue = new Vector<String>();
	}

	public synchronized void send(String item)  {

		if (queue.size() == 0) {
			queue.addElement(item);
		} else if(queue.size() == MAX_BUFFER_SIZE){
			try {
			wait();
			}catch (Exception e){
				
			}
		} else {
			queue.addElement(item);
			System.out.println("Queue at producer: " + queue);
			notifyAll();
		}
		
		
		
	}
	

	

	public synchronized String receive() {

		String item = "Consumer";

		if (queue.size() == 0) {
			System.out.println("Consumer Empty Queue");
			try{
			wait();
			}catch (Exception e){
				
			}
			item = queue.firstElement();
			queue.remove(0);
			System.out.println("Queue at consumer: " + queue);
			notifyAll();
			return item;
		} else {
			
			item = queue.firstElement();
			queue.remove(0);
			System.out.println("Queue at consumer: " + queue);
			notifyAll();

		}

		return item;

	}
}
// }
