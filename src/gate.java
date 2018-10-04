import java.util.Random;
import java.io.*;

public class gate extends Thread {

	Counter counter;
	int gatePosition;

	public gate(Counter counter, int gatePosition) {
		this.counter = counter;
		this.gatePosition = gatePosition;
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			counter.accessFile(gatePosition);
		}

	}

}