import java.io.FileWriter;
import java.net.Socket;

public class Client {
	
	private static String host;
	private static int port; 
	
	public Client(String host, int port){
		System.out.println(Thread.currentThread().getName());
        try
        {
            //Socket s = new Socket("127.0.0.1",5155);
            Socket s = new Socket(host, port);
            s.close();
        }catch (java.io.IOException e) {
            System.out.println(e);System.exit(1);
        }
		this.host = host;
		this.port = port;
	}
	
	public static void main(String argv[]){
		
		if ((argv.length < 1) || (argv.length > 2))
        { System.out.println("Usage: [host] <port>") ; System.exit (1) ;
        }
        String server_host = argv[0] ;
        int server_port = port ;
        if (argv.length == 2)
            server_port = Integer.parseInt (argv[1]) ;
        Client client = new Client(server_host, server_port); 
	
		System.out.println("Ring element hostname is "+ host);
		System.out.println("Ring element port is "+ port);
		
		// clear out file used by ring nodes
		System.out.println("Clearing record.txt file");
		try {
		 // create fileWriter - false = new file so clear contents
		 FileWriter fw_id = new FileWriter("record.txt", false);
		 // that's it - all now cleaned up
		 fw_id.close() ;
		} 
		catch (java.io.IOException e) {
			System.err.println("Exception in xxx clearing file: main: " +e);
		}
	}
	
}
