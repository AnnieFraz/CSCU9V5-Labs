package ThomasPractice;

public class NewThread extends Thread {
    String name;
    IntHolder x2;
    int x;


    public NewThread(IntHolder x2, String name ) {
        this.x2 = x2;
        this.name = name;

    }

    @Override
    public  void run(){
                /*
                x = x * 3;
                x2.setX(x);
                */

            for (int i =0; i < 100; i++) {
                x = x2.addAndGet();

                try {
                    Thread.sleep(10);
                }catch (InterruptedException e){

                }
                System.out.println(x + " " + name);
            }


            /*
        } else if(name.equals("t1")){
                x = x2.getX();
                x = x * 2;
                x2.setX(x);
                */


        System.out.println("x is " + x + " " + name);
        x = x2.getX();


    }
}
