import java.rmi.RemoteException;
import java.util.Date;

public class Consumer extends Thread {

    public String input;
    public MessageQueue messageQueue;

    public Consumer(MessageQueue messageQueue) {
        input = "Consumer Input";

        this.messageQueue = messageQueue;

    }

    public void run()  {
      //  while (true) {
    	String item = " ";
    	Date date = new Date();
            for (int i = 0; i < 25; i++) {
            	
				try {
					item = messageQueue.receive();
					System.out.println("Consumer recieved:  " + item + "at" + date.toString() );
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (item.equals(null)) {
                    System.out.println("Error, Job is Null");
                }
          //  }

        }

    }
}
