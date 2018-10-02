
public class Consumer extends Thread{

	
	public String input;
	public MessageQueue messageQueue; 
	
	public Consumer(MessageQueue messageQueue){
		input = "Consumer Input";
		
		this.messageQueue = messageQueue;
		
	}
	
	public void run(){
		while (true){
			String item = messageQueue.receive();
		/*if (item.equals(null)){
			System.out.println("Error");
			
		}else{
			System.out.println(item);
			
		}*/
		}
		
	}
}
