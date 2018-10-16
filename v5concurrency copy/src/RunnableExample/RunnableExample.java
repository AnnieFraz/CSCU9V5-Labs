package RunnableExample;

import ThomasPractice.IntHolder;

public class RunnableExample implements Runnable{

    IntHolder x2;
    int x;

    public RunnableExample(IntHolder x2) {
        this.x2 = x2;

    }


    @Override
    public  void run(){
        for (int i =0; i < 100; i++) {
            x = x2.addAndGet();

            try {
                Thread.sleep(10);
            }catch (InterruptedException e){

            }
            System.out.println(x + " " + Thread.currentThread().getName());
        }
    }
}
