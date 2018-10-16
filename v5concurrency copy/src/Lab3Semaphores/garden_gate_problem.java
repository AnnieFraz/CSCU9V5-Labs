package Lab3Semaphores;

import java.io.*;
import java.util.concurrent.Semaphore;

public class garden_gate_problem {

	static public void main(String[] args) {
		RandomAccessFile admin;
		Semaphore accessObj = new Semaphore(1,true);
		byte init[] = { 0 };

		try
		{
			admin = new RandomAccessFile("admin.txt", "rw");
			admin.seek(0);
			admin.write(init);
			admin.close();
		}
		catch (IOException e)
		{
			System.out.println("something wrong with file access" + e);
		}

		gate topGate = new gate("Top Gate", accessObj);
		gate bottomGate = new gate("Bottom Gate", accessObj);
		topGate.start();
		bottomGate.start();
	}
}
