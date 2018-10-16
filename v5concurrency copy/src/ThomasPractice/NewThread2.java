package ThomasPractice;

public class NewThread2 extends Thread {
    int x;

    public NewThread2(int x) {
        this.x = x;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
        x = x * 2;
        System.out.println("x is " + x);

        //else if (Thread.currentThread().getName().equals("Thread-1")) {
    }
}
