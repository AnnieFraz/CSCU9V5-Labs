
public class Server {

	public Server() {
		MessageQueue messageQueue = new MessageQueue();

		Producer producer = new Producer(messageQueue);
		Consumer consumer = new Consumer(messageQueue);
		
		producer.start();
		consumer.start();
		

	}

	public static void main(String[] args) {

		Server server = new Server();
	}
}
