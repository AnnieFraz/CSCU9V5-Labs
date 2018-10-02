
public class Producer extends Thread {
	
	public String input;
	public MessageQueue messageQueue; 
	
	private int MAX_BUFFER_SIZE= 10; 
	
	public Producer(MessageQueue messageQueue){
		input = "Producer Input";
		
		this.messageQueue = messageQueue;
		
	}
	
	public void run(){
		int i = 0;
		while (true){
			
			String input = "Producer input";
			messageQueue.send(input);
			//i++;
			try {
			Thread.sleep(1000);
			}catch (Exception e){
				
			}
			}
		
		
	}
	
}
