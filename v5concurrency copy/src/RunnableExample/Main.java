package RunnableExample;

import ThomasPractice.IntHolder;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        int x = 0;
        IntHolder x2 = new IntHolder(x);
        //Thread t1 = new Thread(new RunnableExample(x2));
        //Thread t2 = new Thread(new RunnableExample(x2));

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
               // Logger Log = new Logger(getClass());
                int x;
                for (int i =0; i < 100; i++) {
                    x = x2.addAndGet();

                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException e){

                    }
                    System.out.println(x + " " + Thread.currentThread().getName() );
                }
            }
        };

        Runnable runnable1 = new RunnableExample(x2);

        Thread t1 = new Thread(runnable);
        //Thread t2 = new Thread(runnable1);
        runnable.run();
        //runnable1.run();

        t1.start();
        //t1.run();
        //t2.run();
       // t2.start();
    }
}
