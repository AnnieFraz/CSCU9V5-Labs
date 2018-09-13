package lab0_Java_Refresh;

import java.io.RandomAccessFile;


import java.util.Random;
import java.io.*;

public class gate {

    RandomAccessFile admin;

    public gate()
    {
        try {
            admin = new RandomAccessFile("admin.txt", "rw");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void counting()
    {
        try {
            int counter;

            for (int i =0; i < 51; i++) {

                admin.seek(0);

                counter = admin.read();
                Thread.sleep((int)(Math.random() *500 +0));
                System.out.println(counter);

                counter = counter + 1;

                admin.seek(0);
                admin.write(counter);
                Thread.sleep((int)(Math.random() *500 +0));
            }
            admin.close();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
