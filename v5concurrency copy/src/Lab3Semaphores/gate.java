package Lab3Semaphores;

import javax.sound.midi.SysexMessage;
import java.util.Random;
import java.io.*;
import java.util.concurrent.Semaphore;

public class gate extends Thread {

	RandomAccessFile admin;
	int internal_count;
	int ranumber;
	int count;
	Random ra;
	String me;
	Semaphore sem;

	public gate(String g, Semaphore sem) {
		try {
			admin = new RandomAccessFile("admin.txt", "rw");
		} catch (IOException e) {
			System.out.println(e);
		}
		internal_count = 0;
		count = 0;
		ra = new Random();
		me = g;
		this.sem = sem;
	}

	@Override
	public void run()
	{
		counting();
	}


	public synchronized void counting() {

		byte t[] = { 0 };

		for (int i = 0; i < 50; i++) {
			try {
				ranumber = ra.nextInt(500);
				sem.acquire();
				admin.seek(0);
				admin.read(t);
				count = t[0];
				Thread.sleep(ranumber);
				count = count + 1;
				internal_count++;
				t[0] = (byte) count;
				admin.seek(0);
				admin.write(t);
				ranumber = ra.nextInt(500);
				Thread.sleep(ranumber);
				sem.release();
				notifyAll();
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(me + ": Shared Counter: " + count + " internal counter: " + internal_count);
		}
	}
}
