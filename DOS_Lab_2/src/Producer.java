import java.rmi.RemoteException;
import java.util.Date;

public class Producer extends Thread {

    public String input;
    public MessageQueue messageQueue;

    private int MAX_BUFFER_SIZE = 10;

    public Producer(MessageQueue messageQueue) {
        input = "Producer Input";

        this.messageQueue = messageQueue;

    }

    public void run() {
        //while (true) {
    	Date date = new Date();
            for (int i = 0; i < 25; i++) {
                String input = "Producer input";
                try {
                	 try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					messageQueue.send("no:"+i);
					System.out.println("Producer Sent: " + input + "at" + date.toString());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            //}

        }

    }

}
