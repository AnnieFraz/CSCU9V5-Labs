package Lab2;

import java.util.*;
import Lab2.Consumer;
import Lab2.Producer;

public class MessageQueue {

    private Vector<String> queue;

    private int MAX_BUFFER_SIZE = 10;

    public MessageQueue() {
        queue = new Vector<String>();
    }

    public synchronized void send(String item)  {

        while (queue.size() == MAX_BUFFER_SIZE) {
            try{
                wait();
            }catch(Exception e){

            }

        }
        queue.addElement(item);
        System.out.println("Queue at producer: " + queue);
        notifyAll();


    }


    public synchronized String receive() {

        String item = "Consumer";

        while (queue.size() == 0) {
            try{
                wait();
            }catch(Exception e){

            }

        }
            item = queue.firstElement();
            queue.remove(0);
            System.out.println("Queue at consumer: " + queue);
            notifyAll();
            return item;



    }
}
