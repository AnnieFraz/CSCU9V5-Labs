import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class CriticalRegion extends Thread {

	private String this_host;
	private int this_port;
	private String next_host;
	private int next_port;
	
	private Socket outputLine;

	public CriticalRegion(String this_host, int this_port, String next_host, int next_port) {
		this.this_host = this_host;
		this.this_port = this_port;
		this.next_host = next_host;
		this.next_port = next_port;
		
	}



	public void run() {

		System.out.println("Ring node " + Thread.currentThread().getName() + "now realising the token");
		
		// Host
		try {
			System.out.println("Writing to file: record.txt");
			System.out.println("   ... started a thread to perform critical region");
			
			System.out.println("Ring node " + Thread.currentThread().getName() + " now releasing the token");
			Date timestmp = new Date();
			String timestamp = timestmp.toString();
			// Next create fileWriter - true means writer *appends*
			FileWriter fw_id = new FileWriter("record.txt", true);
			// Create PrintWriter - true = flush buffer on each println
			PrintWriter pw_id = new PrintWriter(fw_id, true);
			// println means adds a newline (as distinct from print)
			pw_id.println("Record from ring node on host " + this_host + ", port number " + this_port + ", is " + timestamp);
			pw_id.close();
			fw_id.close();
			System.out.println("Ring node " + Thread.currentThread().getName() + " has released token");
		} catch (java.io.IOException e) {
			System.out.println("Error writing to file: " + e);
		}

		try {
			sleep(3000);
		} catch (java.lang.InterruptedException e) {
			System.out.println("sleep failed: " + e);
		}

		// Next
		try {// connect to next node in the ring - signals passing the token.
			Socket s = new Socket(next_host, next_port);
			if (s.isConnected()) {
				// Did it connect OK?
				System.out.println("Socket to next node (" + next_host + ": " + next_port + ") connected OK");
			}

			else {
				System.out.println("** Socket to next ring node (" + next_host + ": " + next_port + ") failed to connect");
			}
			try {
				sleep(100);
				// a short delay before closing socket.
			} catch (java.lang.InterruptedException e) {
				System.out.println("sleep fail: " + e);
			}

			s.close(); // token now passed.

			try {
				sleep(100); // another short delay
			} catch (java.lang.InterruptedException e) {
				System.out.println("sleep fail: " + e);
			}

			if (s.isClosed()) {
				System.out.println("Socket to next ring node (" + next_host + ": " + next_port + ") is now closed");
			} else {
				System.out.println("** Socket to next ring node (" + next_host + ": " + next_port + ") is still open!!");
			}
		} catch (Exception e) {

		}

		// end of socket try

	}
}
