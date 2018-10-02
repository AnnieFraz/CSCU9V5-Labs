
public class Producer extends Thread {

	public String input;
	public MessageQueue messageQueue;

	private int MAX_BUFFER_SIZE = 10;

	public Producer(MessageQueue messageQueue) {
		input = "Producer Input";

		this.messageQueue = messageQueue;

	}

	public void run() {
		while (true) {

			for (int i = 0; i < 25; i++) {
				String input = "Producer input";
				messageQueue.send("no:"+i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}

	}

}
