
import java.util.*;

public class MessageQueue {
	
	private Vector<String> queue; 
	
	private int MAX_BUFFER_SIZE= 10;

	public MessageQueue(){
		queue = new Vector<String>();
		
	}
	
	public void send(String item) {
		
		
				synchronized(queue){
				queue.addElement(item);
				System.out.println("Queue at producer: " + queue);
				queue.notify();
				}
			
	}
		//}
			/*
			System.out.println("producer Empty Queue");
		}else{
		
		
		//for(int i = 0; i < 10; i++){
			queue.addElement(item);
			System.out.println("Queue at producer: " + queue);
		
		}
	
	
	/*
	public synchronised void send(String item){
		
	}*/
	
	public String receive(){
		
		String item = "Consumer";
		
		synchronized(queue){
		if (queue.size() == 0){
			
				try{
				queue.wait();
				System.out.println("Consumer Empty Queue");
				return null;
				}
				catch (Exception e){
					System.out.println(e);
				}
			}
		
				else{
					queue.notifyAll();
					item = queue.firstElement();
					queue.remove(0);
					System.out.println("Queue at consumer: " + queue);
					
				}
		
	
		return item;
		
	}
	}
}
