import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Counter extends Thread {

	RandomAccessFile admin;

	public Counter() {
		try {
			this.admin = new RandomAccessFile("admin.txt", "rw");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized int accessFile(int gatePosition) {
		int counter = 0;
		String gate = "";
		if (gatePosition == 0) {
			gate = "bottom";
		} else if (gatePosition == 1) {
			gate = "top";
		}

		try {
			admin.seek(0);
			counter = admin.read();
			counter = counter + 1;
			System.out.println(gatePosition + ":" + gate + ":" + counter);
			admin.seek(0);
			admin.write(counter);
			Thread.sleep((int) (Math.random() * 500 + 0));
			if (counter >= 100) {
				admin.close();
			}
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		return counter;

	}

}
