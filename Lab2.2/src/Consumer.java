
public class Consumer extends Thread {

	public String input;
	public MessageQueue messageQueue;

	public Consumer(MessageQueue messageQueue) {
		input = "Consumer Input";

		this.messageQueue = messageQueue;

	}

	public void run() {
		while (true) {
		
			for (int i = 0; i < 10; i++) {
				String item = messageQueue.receive();
				if (item.equals(null)) {
					System.out.println("Error");
				}
			}
		
		}

	}
}
