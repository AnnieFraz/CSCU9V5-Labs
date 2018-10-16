package AndreaPractice;


import java.util.*;

public class MessageQueue{
	
	private Vector<String> queue;	
	
	public MessageQueue() {
		queue = new Vector<String>();
	}
   

	public void send(String item) {
		queue.addElement(item);
		System.out.println(queue);
	}

	public String receive() {
    String item;
    
    if (queue.size() == 0)
        return null;
    else {
    	item = queue.firstElement();        
        queue.removeElementAt(0);
		System.out.println(queue);
        return item;
    	}	
	}

	
}

