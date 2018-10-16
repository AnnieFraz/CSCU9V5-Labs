package ThomasPractice;

import java.util.concurrent.locks.ReentrantLock;

public class IntHolder  {
    public int x ;

    //ReentrantLock Lock = new ReentrantLock();

    public IntHolder(int x) {
        this.x = x;
    }

    public  int getX() {

        return x;
    }

    public synchronized void setX(int x) {
        //notifyAll();
        //Lock.lock();
        this.x = x;
    }

    public final synchronized int addAndGet() {
        x = x+1;
       // Lock.unlock();
        return x ;
    }
}
