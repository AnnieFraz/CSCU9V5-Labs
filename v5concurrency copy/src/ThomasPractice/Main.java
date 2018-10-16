package ThomasPractice;

public class Main {


    public static void main(String[] args) {
        int x = 0;
        IntHolder x2 = new IntHolder(x);
        Thread t1 = new NewThread(x2, "t0");
        Thread t2 = new NewThread(x2, "t1");

        t1.start();
        t2.start();

        //synchronized (x2){

            x = x2.getX();
            System.out.println("x main is " + x2.getX());
        //}






    }


}

