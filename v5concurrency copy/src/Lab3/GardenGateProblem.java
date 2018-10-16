package Lab3;

import java.util.Random;
import java.io.*;

public class GardenGateProblem {

    static public void main(String[] args) {

        RandomAccessFile admin;
        byte init[] = { 0 };

        int gatePosition = 0;

        int counterBottom = 0;
        int counterTop = 0;
        try {
            admin = new RandomAccessFile("admin.txt", "rw");
            admin.seek(0);
            admin.write(init);
            admin.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        Counter counterBot = new Counter();
        Gate gateBottom = new Gate(counterBot, 0);
        gateBottom.start();

        System.out.println("running the top gate");
        gatePosition = 1;

        Counter counterT = new Counter();
        Gate gateTop = new Gate(counterT, gatePosition);
        gateTop.start();

        int result = counterTop + counterBottom;
        System.out.println("Result: " + result);

    }

}
