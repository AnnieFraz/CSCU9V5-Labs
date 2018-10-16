package Lab2;

public class Consumer extends Thread {

    public String input;
    public MessageQueue messageQueue;

    public Consumer(MessageQueue messageQueue) {
        input = "Consumer Input";

        this.messageQueue = messageQueue;

    }

    public void run() {
      //  while (true) {

            for (int i = 0; i < 25; i++) {
                String item = messageQueue.receive();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }/*
                if (item.equals(null)) {
                    System.out.println("Error");
                }*/
          //  }

        }

    }
}
